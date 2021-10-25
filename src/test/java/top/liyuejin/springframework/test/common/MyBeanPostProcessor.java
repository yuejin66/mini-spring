package top.liyuejin.springframework.test.common;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanPostProcessor;
import top.liyuejin.springframework.test.bean.customer.CustomerService;

/**
 * @author lyj
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if ("customerService".equals(beanName)) {
            CustomerService customerService = (CustomerService) bean;
            customerService.setLocation("改为：杭州");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
