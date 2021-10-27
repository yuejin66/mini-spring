package main.java.com.yuejin66.springframework.context.event;

import main.java.com.yuejin66.springframework.beans.factory.BeanFactory;
import main.java.com.yuejin66.springframework.context.ApplicationEvent;
import main.java.com.yuejin66.springframework.context.ApplicationListener;

/**
 * @author lyj
 */
@SuppressWarnings("unchecked")
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
