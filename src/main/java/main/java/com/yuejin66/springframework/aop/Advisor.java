package main.java.com.yuejin66.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * 定义 Advisor 访问者
 *
 * @author lyj
 */
public interface Advisor {

    Advice getAdvice();
}
