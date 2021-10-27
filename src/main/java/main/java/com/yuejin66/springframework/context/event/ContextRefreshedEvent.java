package main.java.com.yuejin66.springframework.context.event;

/**
 * 监听刷新动作
 *
 * @author yuejin66
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
