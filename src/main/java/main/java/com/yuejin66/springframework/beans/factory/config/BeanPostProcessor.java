package main.java.com.yuejin66.springframework.beans.factory.config;

import main.java.com.yuejin66.springframework.beans.BeansException;

/**
 * 用于修改新实例化 Bean 对象的扩展点（需要注意一点，我们定义一个类实现了BeanPostProcessor，默认是会对整个Spring容器中所有的bean进行处理）
 *
 * @author yuejin66
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象开始初始化之前，执行此方法
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象开始初始化之后，执行此方法
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
