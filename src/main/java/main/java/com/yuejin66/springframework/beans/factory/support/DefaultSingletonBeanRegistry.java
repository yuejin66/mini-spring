package main.java.com.yuejin66.springframework.beans.factory.support;

import main.java.com.yuejin66.springframework.beans.BeansException;
import main.java.com.yuejin66.springframework.beans.factory.DisposableBean;
import main.java.com.yuejin66.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 保存和获取单例对象，再次使用该 Bean 时不需要再重复创建，直接从这里获取
 *
 * @author lyj
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected static final Object NULL_OBJECT = new Object();

    private final Map<String, Object> singletonObjects = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();
        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }

    /**
     * 注意使用 protected 是只允许继承了 DefaultSingletonBeanRegistry 的子类才能使用该方法
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
