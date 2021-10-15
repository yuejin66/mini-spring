package main.java.top.liyuejin.springframework.beans.factory;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.config.AutowireCapableBeanFactory;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanPostProcessor;
import main.java.top.liyuejin.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 提供分析和修改 Bean 以及预先实例化的操作接口
 *
 * @author tom lee
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
