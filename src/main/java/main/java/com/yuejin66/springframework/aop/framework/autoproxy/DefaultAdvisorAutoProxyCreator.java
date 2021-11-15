package main.java.com.yuejin66.springframework.aop.framework.autoproxy;

import main.java.com.yuejin66.springframework.aop.*;
import main.java.com.yuejin66.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import main.java.com.yuejin66.springframework.aop.framework.ProxyFactory;
import main.java.com.yuejin66.springframework.beans.BeansException;
import main.java.com.yuejin66.springframework.beans.factory.BeanFactory;
import main.java.com.yuejin66.springframework.beans.factory.BeanFactoryAware;
import main.java.com.yuejin66.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import main.java.com.yuejin66.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * 融入 Bean 生命周期的自动代理创建者
 *
 * @author lyj
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (isInfrastructureClass(beanClass)) return null;
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(beanClass)) continue;

            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (InstantiationException |
                    IllegalAccessException |
                    InvocationTargetException |
                    NoSuchMethodException e) {
                e.printStackTrace();
            }
            AdvisedSupport advisedSupport = new AdvisedSupport();
            advisedSupport.setTargetSource(targetSource);                                 // 目标对象
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice()); // 拦截方法
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());    // 匹配器
            advisedSupport.setProxyTargetClass(false);                                    // 是否代理目标对象
            return new ProxyFactory(advisedSupport).getProxy();
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) ||
                Pointcut.class.isAssignableFrom(beanClass) ||
                Advisor.class.isAssignableFrom(beanClass);
    }
}
