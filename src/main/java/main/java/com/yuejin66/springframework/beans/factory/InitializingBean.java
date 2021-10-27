package main.java.com.yuejin66.springframework.beans.factory;

/**
 * @author lyj
 */
public interface InitializingBean {

    /**
     * Bean 进行属性填充后调用
     */
    void afterPropertiesSet() throws Exception;
}
