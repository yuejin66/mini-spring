package top.liyuejin.springframework.test;

import cn.hutool.core.io.IoUtil;
import main.java.top.liyuejin.springframework.beans.PropertyValue;
import main.java.top.liyuejin.springframework.beans.PropertyValues;
import main.java.top.liyuejin.springframework.beans.core.io.DefaultResourceLoader;
import main.java.top.liyuejin.springframework.beans.core.io.Resource;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanReference;
import main.java.top.liyuejin.springframework.beans.factory.support.DefaultListableBeanFactory;
import main.java.top.liyuejin.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import main.java.top.liyuejin.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import top.liyuejin.springframework.test.bean.customer.CustomerDao;
import top.liyuejin.springframework.test.bean.customer.CustomerService;
import top.liyuejin.springframework.test.bean.student.StudentService;
import top.liyuejin.springframework.test.bean.user.UserService;
import top.liyuejin.springframework.test.common.MyBeanFactoryPostProcessor;
import top.liyuejin.springframework.test.common.MyBeanPostProcessor;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lyj
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void beanFactoryTest() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3. 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "lee");
        userService.queryUserInfo();
    }

    @Test
    public void beanFactory2Test() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册 CustomerDao
        beanFactory.registerBeanDefinition("customerDao", new BeanDefinition(CustomerDao.class));
        // 3. CustomerService 设置属性[id, customerDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id", "10002"));
        propertyValues.addPropertyValue(new PropertyValue("customerDao", new BeanReference("customerDao")));
        // 4. CustomerService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(CustomerService.class, propertyValues);
        beanFactory.registerBeanDefinition("customerService", beanDefinition);
        // 5. CustomerService 获取 bean
        CustomerService customerService = (CustomerService) beanFactory.getBean("customerService");
        customerService.queryCustomerInfo();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("D:\\liyuejin_project\\mini-spring\\src" +
                "\\test\\java\\top\\liyuejin\\springframework\\test\\resources\\important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("http://github.com/yuejin66/mini-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println(content);
    }

    @Test
    public void test_xml() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件 & 注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. 获取 Bean 对象调用对象
        CustomerService customerService = beanFactory.getBean("customerService", CustomerService.class);
        String result = customerService.queryCustomerInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor_1() {
        // 1-2 同上
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:context_1.xml");
        // 3. BeanDefinition  加载完成 & Bean 实例化之前，修改 BeanDefinition  的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        // 4. Bean 实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);
        // 5. 获取 Bean 对象调用
        CustomerService customerService = beanFactory.getBean("customerService", CustomerService.class);
        String result = customerService.getCustomer();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor_2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:context_2.xml");
        // 2. 获取 Bean 对象调用方法
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        String result = customerService.getCustomer();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_hook() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:init&destroy.xml");
        context.registerShutdownHook();
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        String result = customerService.getCustomer();
        System.out.println(result);
    }

    @Test
    public void test_aware() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:init&destroy.xml");
        context.registerShutdownHook();
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        String result = customerService.getCustomer();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware：" + customerService.getApplicationContext());
    }

    // 原型模式（使用 proxy）
    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");
        context.registerShutdownHook();

        Object studentService_1 = context.getBean("studentService", StudentService.class);
        Object studentService_2 = context.getBean("studentService", StudentService.class);

        // 配置 scope="prototype/singleton"
        System.out.println(studentService_1);
        System.out.println(studentService_2);

        // 打印 16 进制哈希
        System.out.println(studentService_1 + " hash：" + Integer.toHexString(studentService_1.hashCode()));

        // 测试 代理方法
        StudentService studentService = context.getBean("studentService", StudentService.class);
        System.out.println("测试代理方法，结果：" + studentService.queryStuInfo());
    }

    // 代理模式

}
