package main.java.com.yuejin66.springframework.context;

import main.java.com.yuejin66.springframework.beans.core.io.ResourceLoader;
import main.java.com.yuejin66.springframework.beans.factory.HierarchicalBeanFactory;
import main.java.com.yuejin66.springframework.beans.factory.ListableBeanFactory;

/**
 * @author yuejin66
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {


}
