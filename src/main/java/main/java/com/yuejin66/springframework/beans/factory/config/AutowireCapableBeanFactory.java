package main.java.com.yuejin66.springframework.beans.factory.config;

import main.java.com.yuejin66.springframework.beans.factory.BeanFactory;

/**
 * @author tom lee
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName);

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessAfterInitialization 方法
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName);
}
