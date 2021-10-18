package main.java.top.liyuejin.springframework.beans;

/**
 * 定义 Bean 异常
 *
 * @author lyj
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
