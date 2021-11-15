package main.java.com.yuejin66.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author lyj
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target) throws Throwable;
}
