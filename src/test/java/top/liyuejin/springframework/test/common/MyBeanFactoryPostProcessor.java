package top.liyuejin.springframework.test.common;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.PropertyValue;
import main.java.top.liyuejin.springframework.beans.PropertyValues;
import main.java.top.liyuejin.springframework.beans.factory.ConfigurableListableBeanFactory;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanDefinition;
import main.java.top.liyuejin.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author lyj
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("customerService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("companyName", "改为：阿里巴巴"));
    }
}
