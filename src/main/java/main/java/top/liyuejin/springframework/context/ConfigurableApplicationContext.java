package main.java.top.liyuejin.springframework.context;

import main.java.top.liyuejin.springframework.beans.BeansException;

/**
 * @author tom lee
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     */
    void refresh() throws BeansException;
}
