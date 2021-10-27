package main.java.com.yuejin66.springframework.beans.factory.config;

/**
 * 单例注册接口
 *
 * @author lyj
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例，用于复用对象
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
