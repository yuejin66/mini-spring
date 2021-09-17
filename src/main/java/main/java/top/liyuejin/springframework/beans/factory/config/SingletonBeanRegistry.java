package main.java.top.liyuejin.springframework.beans.factory.config;

/**
 * @author lyj
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
