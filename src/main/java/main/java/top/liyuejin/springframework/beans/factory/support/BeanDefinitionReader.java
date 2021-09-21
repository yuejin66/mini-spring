package main.java.top.liyuejin.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import main.java.top.liyuejin.springframework.beans.core.io.Resource;
import main.java.top.liyuejin.springframework.beans.core.io.ResourceLoader;

/**
 * @author tom lee
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeanException;

    void loadBeanDefinitions(Resource... resources) throws BeanException;

    void loadBeanDefinitions(String location) throws BeanException;
}
