package com.yuejin66.springframework.aop;

import com.yuejin66.springframework.aop.interceptor.UserServiceInterceptor;
import com.yuejin66.springframework.aop.service.UserService;
import com.yuejin66.springframework.aop.service.UserServiceImpl;
import main.java.com.yuejin66.springframework.aop.AdvisedSupport;
import main.java.com.yuejin66.springframework.aop.TargetSource;
import main.java.com.yuejin66.springframework.aop.aspectj.AspectJExpressionPointcut;
import main.java.com.yuejin66.springframework.aop.framework.Cglib2AopProxy;
import main.java.com.yuejin66.springframework.aop.framework.JdkDynamicAopProxy;
import org.junit.Test;

/**
 * @author lyj
 */
public class ApiTest {

    @Test
    public void test_dynamic() {
        // 目标对象
        UserService userService = new UserServiceImpl();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.yuejin66.springframework.aop.service.UserService.*(..))"));

        // 代理对象（JdkDynamicAopProxy）
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        Object proxy = jdkDynamicAopProxy.getProxy();
        UserService proxy_jdk = (UserService) proxy;
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象（Cglib2AopProxy）
        UserService proxy_cglib = (UserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_cglib.register(""));
    }
}
