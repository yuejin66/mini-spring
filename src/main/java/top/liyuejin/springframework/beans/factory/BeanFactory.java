package main.java.top.liyuejin.springframework.beans.factory;

import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lyj
 *
 * Bean 的注册
 */
public interface BeanFactory {

    Object getBean(String beanName);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
