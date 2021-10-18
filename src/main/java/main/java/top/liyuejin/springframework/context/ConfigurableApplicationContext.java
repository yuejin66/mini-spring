package main.java.top.liyuejin.springframework.context;

import main.java.top.liyuejin.springframework.beans.BeansException;

/**
 * @author yuejin66
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 核心方法。用来刷新容器
     */
    void refresh() throws BeansException;
}
