package main.java.com.yuejin66.springframework.context;

import main.java.com.yuejin66.springframework.beans.BeansException;
import main.java.com.yuejin66.springframework.beans.factory.Aware;

/**
 * 实现此接口，就能感知到所属的 ApplicationContext
 *
 * @author lyj
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
