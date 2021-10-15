package main.java.top.liyuejin.springframework.beans.factory;

import main.java.top.liyuejin.springframework.beans.BeansException;

/**
 * @author lyj
 *
 * Bean 的注册（注册的是定义 Bean 的实例化信息）和获取 Bean 的操作
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object... args) throws BeansException;

    <T> T getBean(String beanName, Class<T> requiredType) throws BeansException;
}
