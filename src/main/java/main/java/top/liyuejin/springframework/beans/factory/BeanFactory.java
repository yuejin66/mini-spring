package main.java.top.liyuejin.springframework.beans.factory;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lyj
 *
 * Bean 的注册
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
