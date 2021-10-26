package main.java.top.liyuejin.springframework.context.event;

/**
 * 监听关闭动作
 *
 * @author yuejin66
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
