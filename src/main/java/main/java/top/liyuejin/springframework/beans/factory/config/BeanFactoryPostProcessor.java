package main.java.top.liyuejin.springframework.beans.factory.config;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author yuejin66
 */
public interface BeanFactoryPostProcessor {

    /**
     *   在所有的 BeanDefinition 加载完成后（Bean 对象注册后），实例化 Bean 对象之前，提供
     * 可以修改 BeanDefinition 属性的机制。
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
