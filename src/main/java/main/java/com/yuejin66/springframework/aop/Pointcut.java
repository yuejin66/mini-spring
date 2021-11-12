package main.java.com.yuejin66.springframework.aop;

/**
 * @author lyj
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
