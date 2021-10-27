package main.java.com.yuejin66.springframework.context;

/**
 * 事件发布者接口
 *
 * @author lyj
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event);
}
