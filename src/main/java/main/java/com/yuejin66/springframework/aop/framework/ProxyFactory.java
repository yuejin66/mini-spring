package main.java.com.yuejin66.springframework.aop.framework;

import main.java.com.yuejin66.springframework.aop.AdvisedSupport;

/**
 * 代理工厂。可以按照不同的创建需求（JDK、Cglib）进行控制。
 *
 * @author lyj
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    public AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
