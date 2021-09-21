package main.java.top.liyuejin.springframework.beans.factory.support;

import main.java.top.liyuejin.springframework.beans.core.io.DefaultResourceLoader;
import main.java.top.liyuejin.springframework.beans.core.io.ResourceLoader;

/**
 * @author tom lee
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    public void containsBeanDefinition(String beanName) {

    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
