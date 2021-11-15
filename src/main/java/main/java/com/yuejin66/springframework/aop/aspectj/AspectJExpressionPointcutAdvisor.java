package main.java.com.yuejin66.springframework.aop.aspectj;

import main.java.com.yuejin66.springframework.aop.Pointcut;
import main.java.com.yuejin66.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author lyj
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    // 切点
    private AspectJExpressionPointcut pointcut;

    // 具体的拦截方法
    private Advice advice;

    // 表达式
    private String expression;

    @Override
    public Pointcut getPointcut() {
        if (null == pointcut) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
