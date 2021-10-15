package main.java.top.liyuejin.springframework.beans.factory.support;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanPostProcessor;
import main.java.top.liyuejin.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lyj
 *
 * 核心实现 BeanFactory，使用模板模式，可以统一收口通用核心方法的调用逻辑和标准定义，
 * 也就很好的控制了后续的实现者不用关心调用逻辑，按照统一方式执行
 */
@SuppressWarnings("unchecked")
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
        implements ConfigurableBeanFactory {

    private final List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
        return (T) doGetBean(beanName, null);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessorList.remove(beanPostProcessor);
        this.beanPostProcessorList.add(beanPostProcessor);
    }

    protected Object doGetBean(final String beanName, final Object[] args) {
        Object bean = getSingleton(beanName);
        if (null != bean)
            return bean;
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
