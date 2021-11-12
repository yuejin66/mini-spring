package com.yuejin66.springframework.ioc.common;

import main.java.com.yuejin66.springframework.beans.BeansException;
import main.java.com.yuejin66.springframework.beans.PropertyValue;
import main.java.com.yuejin66.springframework.beans.PropertyValues;
import main.java.com.yuejin66.springframework.beans.factory.ConfigurableListableBeanFactory;
import main.java.com.yuejin66.springframework.beans.factory.config.BeanDefinition;
import main.java.com.yuejin66.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author lyj
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("customerService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        // 测试在 Bean 实例化之前更改 BeanDefinition。
        propertyValues.addPropertyValue(new PropertyValue("companyName", "改为：阿里巴巴"));
    }
}
