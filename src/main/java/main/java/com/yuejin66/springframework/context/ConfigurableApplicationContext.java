package main.java.com.yuejin66.springframework.context;

import main.java.com.yuejin66.springframework.beans.BeansException;

/**
 * @author yuejin66
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 核心方法。用来刷新容器
     */
    void refresh() throws BeansException;

    /**
     * 注册虚拟机钩子
     */
    void registerShutdownHook();

    /**
     * 手动执行关闭
     */
    void close();
}
