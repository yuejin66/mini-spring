package top.liyuejin.springframework.test;

import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;
import main.java.top.liyuejin.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;
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
}
