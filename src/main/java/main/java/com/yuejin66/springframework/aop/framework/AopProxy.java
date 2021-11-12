package main.java.com.yuejin66.springframework.aop.framework;

/**
 * 代理抽象实现（JDK & Cglib）
 *
 * @author lyj
 */
public interface AopProxy {

    /**
     * 获取代理类
     *
     * @return Object
     */
    Object getProxy();
}
