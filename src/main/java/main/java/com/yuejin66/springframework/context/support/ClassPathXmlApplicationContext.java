package main.java.com.yuejin66.springframework.context.support;

import main.java.com.yuejin66.springframework.beans.BeansException;

/**
 * 应用上下文实现类
 *
 * @author lyj
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {}

    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }

    /**
     * 在 xml 中加载 BeanDefinition，并刷新上下文
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
