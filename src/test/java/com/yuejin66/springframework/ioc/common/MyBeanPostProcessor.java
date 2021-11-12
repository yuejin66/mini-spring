package com.yuejin66.springframework.ioc.common;

import main.java.com.yuejin66.springframework.beans.BeansException;
import main.java.com.yuejin66.springframework.beans.factory.config.BeanPostProcessor;
import com.yuejin66.springframework.ioc.bean.customer.CustomerService;

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
