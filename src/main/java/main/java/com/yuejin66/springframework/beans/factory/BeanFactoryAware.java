package main.java.com.yuejin66.springframework.beans.factory;

import main.java.com.yuejin66.springframework.beans.BeansException;

/**
 * 实现此接口，就能感知到所属的 ClassLoader
 *
 * @author lyj
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
