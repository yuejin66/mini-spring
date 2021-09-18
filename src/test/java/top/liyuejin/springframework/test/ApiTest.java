package top.liyuejin.springframework.test;

import main.java.top.liyuejin.springframework.beans.PropertyValue;
import main.java.top.liyuejin.springframework.beans.PropertyValues;
import main.java.top.liyuejin.springframework.beans.factory.BeanFactory;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanReference;
import main.java.top.liyuejin.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
import top.liyuejin.springframework.test.bean.CustomerDao;
import top.liyuejin.springframework.test.bean.CustomerService;
import top.liyuejin.springframework.test.bean.UserService;

/**
 * @author lyj
 */
public class ApiTest {

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
        propertyValues.addPropertyValue(new PropertyValue("id", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("customerDao", new BeanReference("customerDao")));
        // 4. CustomerService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(CustomerService.class, propertyValues);
        beanFactory.registerBeanDefinition("customerService", beanDefinition);
        // 5. CustomerService 获取 bean
        CustomerService customerService = (CustomerService) beanFactory.getBean("customerService");
        customerService.queryCustomerInfo();
    }
}
