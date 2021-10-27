package main.java.com.yuejin66.springframework.beans.factory;

/**
 * @author lyj
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
