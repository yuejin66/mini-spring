package main.java.com.yuejin66.springframework.aop;

/**
 * Advisor 承担了 Pointcut 和 Advice 的组合，Pointcut 用于获取 JoinPoint，而
 * Advice 决定于 JointPoint 执行什么操作。
 *
 * @author lyj
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
