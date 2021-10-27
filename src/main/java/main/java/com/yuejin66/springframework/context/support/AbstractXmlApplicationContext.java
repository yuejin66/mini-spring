package main.java.com.yuejin66.springframework.context.support;

import main.java.com.yuejin66.springframework.beans.factory.support.DefaultListableBeanFactory;
import main.java.com.yuejin66.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 上下文对配置信息的加载
 *
 * @author lyj
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
