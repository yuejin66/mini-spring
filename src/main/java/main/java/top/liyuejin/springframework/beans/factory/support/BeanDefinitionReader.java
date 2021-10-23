package main.java.top.liyuejin.springframework.beans.factory.support;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.core.io.Resource;
import main.java.top.liyuejin.springframework.beans.core.io.ResourceLoader;

import java.io.InputStream;

/**
 * Bean 定义读取接口
 *
 *   这里需要注意 getRegistry()、getResourceLoader()，都是用于提供给后面 loadBeanDefinitions
 * 方法的工具，加载和注册，这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法。
 *
 * @author yuejin66
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;
}
