package main.java.top.liyuejin.springframework.beans.factory.config;

import main.java.top.liyuejin.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * 可获取 BeanPostProcessor、BeanClassLoader 等的一个配置化接口
 *
 * @author tom lee
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    // 单例
    String SCOPE_SINGLETON = "singleton";

    // 多例
    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
