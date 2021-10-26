package main.java.top.liyuejin.springframework.context.event;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.BeanFactory;
import main.java.top.liyuejin.springframework.beans.factory.BeanFactoryAware;
import main.java.top.liyuejin.springframework.context.ApplicationEvent;
import main.java.top.liyuejin.springframework.context.ApplicationListener;
import main.java.top.liyuejin.springframework.utils.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author yuejin66
 */
@SuppressWarnings("unchecked")
public abstract class AbstractApplicationEventMulticaster
        implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        LinkedList<ApplicationListener> allListeners = new LinkedList<>();
        applicationListeners.forEach(listener -> {
            if (supportsEvent(listener, event)) {
                allListeners.add(listener);
            }
        });
        return allListeners;
    }

    /**
     * 监听器是否对该事件感兴趣
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();

        // 按照 Cglib 和 JDK 不同的实例化类型，判断后获取目标 class
        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name：" + className);
        }
        // 判定此 eventClassName  对象所表示的类或接口与指定的 event.getClass()  参数所表示的类或接口是否相同，或是否是其超类或超接口。
        // isAssignableFrom 是用来判断子类和父类的关系的，或者接口的实现类和接口的关系的，默认所有的类的终极父类都是 Object 。
        // 如果 A.isAssignableFrom(B) 结果是 true ，证明 B 可以转换成为 A, 也就是 A 可以由 B 转换而来
        return eventClassName.isAssignableFrom(event.getClass());
    }
}
