package main.java.top.liyuejin.springframework.beans.factory.config;

import main.java.top.liyuejin.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author tom lee
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
