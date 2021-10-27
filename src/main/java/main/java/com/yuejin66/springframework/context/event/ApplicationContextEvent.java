package main.java.com.yuejin66.springframework.context.event;

import main.java.com.yuejin66.springframework.context.ApplicationContext;
import main.java.com.yuejin66.springframework.context.ApplicationEvent;

/**
 * @author yuejin66
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
