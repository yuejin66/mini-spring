package main.java.top.liyuejin.springframework.context;

import java.util.EventListener;

/**
 * @author yuejin66
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理应用程序事件
     */
    void onApplicationEvent(E event);
}
