package main.java.com.yuejin66.springframework.context;

import java.util.EventObject;

/**
 * 定义和实现事件
 *
 * @author yuejin66
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
