package main.java.com.yuejin66.springframework.beans.factory.support;

import main.java.com.yuejin66.springframework.beans.BeansException;
import main.java.com.yuejin66.springframework.beans.factory.ConfigurableListableBeanFactory;
import main.java.com.yuejin66.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 核心实现类，能获取和注册 Bean 的定义
 *
 * 1. 继承 AbstractBeanFactory，能够获取 Bean 的定义。
 * 2. 同时也实现 BeanDefinitionRegistry 接口的 registerBeanDefinition 方法，能够注册 Bean 的定义。
 *
 * @author lyj
 */
@SuppressWarnings("unchecked")
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
        implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition)
            throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, BeanDefinition) -> {
            Class<?> beanClass = BeanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }
}
