package main.java.com.yuejin66.springframework.beans.factory;

import main.java.com.yuejin66.springframework.beans.BeansException;

import java.util.Map;

/**
 * 扩展 Bean 工厂接口的接口
 *
 * @author tom lee
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回 Bean 实例
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
