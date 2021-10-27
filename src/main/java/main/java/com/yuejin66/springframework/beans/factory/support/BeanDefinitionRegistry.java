package main.java.com.yuejin66.springframework.beans.factory.support;

import main.java.com.yuejin66.springframework.beans.BeansException;
import main.java.com.yuejin66.springframework.beans.factory.config.BeanDefinition;

/**
 * @author lyj
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用 Bean 的名称来查询 BeanDefinition
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的 BeanDefinition
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的 Bean 名称
     */
    String[] getBeanDefinitionNames();
}
