package main.java.top.liyuejin.springframework.beans.factory;

/**
 * @author lyj
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
