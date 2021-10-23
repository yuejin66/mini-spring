package main.java.top.liyuejin.springframework.beans.factory;

/**
 * @author yuejin66
 */
public interface FactoryBean<T> {

    /**
     * 获取对象
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     */
    Class<?> getObjectType();

    /**
     * 是否是单例对象
     */
    boolean isSingleton();
}
