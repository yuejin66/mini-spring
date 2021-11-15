package main.java.com.yuejin66.springframework.beans.factory.config;

import main.java.com.yuejin66.springframework.beans.BeansException;

/**
 * @author lyj
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
