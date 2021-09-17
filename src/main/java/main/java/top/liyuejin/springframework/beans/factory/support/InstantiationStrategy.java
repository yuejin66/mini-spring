package main.java.top.liyuejin.springframework.beans.factory.support;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author lyj
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName,
                       Constructor<?> constructor, Object[] args) throws BeansException;
}
