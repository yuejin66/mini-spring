package com.yuejin66.springframework.ioc;

import cn.hutool.core.io.IoUtil;
import com.yuejin66.springframework.ioc.bean.customer.CustomerDao;
import com.yuejin66.springframework.ioc.common.MyBeanPostProcessor;
import com.yuejin66.springframework.ioc.event.CustomEvent;
import main.java.com.yuejin66.springframework.aop.aspectj.AspectJExpressionPointcut;
import main.java.com.yuejin66.springframework.beans.PropertyValue;
import main.java.com.yuejin66.springframework.beans.PropertyValues;
import main.java.com.yuejin66.springframework.beans.core.io.DefaultResourceLoader;
import main.java.com.yuejin66.springframework.beans.core.io.Resource;
import main.java.com.yuejin66.springframework.beans.factory.config.BeanDefinition;
import main.java.com.yuejin66.springframework.beans.factory.config.BeanReference;
import main.java.com.yuejin66.springframework.beans.factory.support.DefaultListableBeanFactory;
import main.java.com.yuejin66.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import main.java.com.yuejin66.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
import org.junit.Test;
import com.yuejin66.springframework.ioc.bean.customer.CustomerService;
import com.yuejin66.springframework.ioc.bean.student.StudentService;
import com.yuejin66.springframework.ioc.bean.user.UserService;
import com.yuejin66.springframework.ioc.common.MyBeanFactoryPostProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @author lyj
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    /**
     * 注册、获取和实例化 Bean
     */
    @Test
    public void test_beanFactory() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3. 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "lee");
        String info = userService.queryUserInfo();
        System.out.println("测试结果：" + info);
    }

    /**
     * 注册、获取和实例化 Bean，可以添加属性
     */
    @Test
    public void test_beanFactory_haveProperValues() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册 CustomerDao
        beanFactory.registerBeanDefinition("customerDao", new BeanDefinition(CustomerDao.class));
        // 3. CustomerService 设置属性[id, customerDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("id", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("customerDao", new BeanReference("customerDao")));
        // 4. 注册 CustomerService
        beanFactory.registerBeanDefinition("customerService", new BeanDefinition(CustomerService.class, propertyValues));
        // 5. CustomerService 获取 bean
        CustomerService customerService = (CustomerService) beanFactory.getBean("customerService");
        String info = customerService.queryCustomerInfo();
        System.out.println("测试结果：" + info);
    }

    /**
     * 加载文件（classpath）
     */
    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println("测试结果：" + content);
    }

    /**
     * 加载文件（相对/绝对路径）
     */
    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println("测试结果：" + content);
    }

    /**
     * 加载文件（http）
     */
    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://www.yuejin66.com/file/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println("测试结果：" + content);
    }

    /**
     * 加载和解析 xml 文件
     */
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

    /**
     * 测试应用上下文
     */
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

    /**
     * 测试应用上下文（xml 中带上 BeanPostFactoryProcessor 和 BeanPostProcessor）。
     * 对比上面的方法，主要是隐藏了 DefaultListableBeanFactory，提供了修改 Bean 的定义信息
     * 和扩展 Bean 的实例化信息功能（准确来说是在初始化前后，但此处还没实现 Bean 的初始化）。
     */
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor_haveMyBeanPostProcessor() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:context_2.xml");
        // 获取 Bean 对象调用方法
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        String result = customerService.getCustomer();
        System.out.println("测试结果：" + result);
    }

    /**
     * 钩子调用销毁方法
     */
    @Test
    public void test_hook() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:init&destroy.xml");
        context.registerShutdownHook();
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        String result = customerService.getCustomer();
        System.out.println(result);
    }

    /**
     * 测试感知容器对象
     */
    @Test
    public void test_aware() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:init&destroy.xml");
        context.registerShutdownHook();
        CustomerService customerService = context.getBean("customerService", CustomerService.class);
        String result = customerService.getCustomer();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware：" + customerService.getApplicationContext());
    }

    /**
     * 原型模式（使用 proxy 代理）
     */
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

    /**
     * 测试对象作用域和 FactoryBean
     */
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:event.xml");
        context.publishEvent(new CustomEvent(context, 1019129009086763L, "成功了！"));
        context.registerShutdownHook();
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut(
                "execution(* com.yuejin66.springframework.ioc.bean.customer.CustomerService.*(..))");
        Class<CustomerService> clazz = CustomerService.class;
        Method method = clazz.getDeclaredMethod("queryCustomerInfo");

        System.out.println(pointcut.matches(clazz));         // true
        System.out.println(pointcut.matches(method, clazz)); // true
    }
}
