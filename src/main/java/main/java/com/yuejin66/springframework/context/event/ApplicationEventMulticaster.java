package main.java.com.yuejin66.springframework.context.event;

import main.java.com.yuejin66.springframework.context.ApplicationEvent;
import main.java.com.yuejin66.springframework.context.ApplicationListener;

/**
 * 事件广播器
 *
 * @author yuejin66
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加一个监听器，用来通知所有的事件。
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 从通知列表中删除监听器。
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 将给定的应用程序事件多播到适当的侦听器（注意单播、多播和广播的区别）
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
