package main.java.com.yuejin66.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author lyj
 */
public interface MethodMatcher {

    /**
     * 方法匹配，在表达式范围内匹配到目标类和方法。
     *
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method, Class<?> targetClass);
}
