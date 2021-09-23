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
import org.junit.Before;
import org.junit.Test;
import top.liyuejin.springframework.test.bean.CustomerDao;
import top.liyuejin.springframework.test.bean.CustomerService;
import top.liyuejin.springframework.test.bean.UserService;

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
    public void classpathTest() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println(content);
    }

    @Test
    public void fileTest() throws IOException {
        Resource resource = resourceLoader.getResource("D:\\liyuejin_project\\mini-spring\\src" +
                "\\test\\java\\top\\liyuejin\\springframework\\test\\resources\\important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println(content);
    }

    @Test
    public void urlTest() throws IOException {
        Resource resource = resourceLoader.getResource("http://github.com/yuejin66/mini-spring/important.properties");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.read(inputStream, "UTF-8");
        System.out.println(content);
    }

    @Test
    public void xmlTest() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件 & 注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. 获取 Bean 对象调用对象
        CustomerService customerService = beanFactory.getBean("customerService", CustomerService.class);
        String info = customerService.queryCustomerInfo();
        System.out.println(info);
    }
}
