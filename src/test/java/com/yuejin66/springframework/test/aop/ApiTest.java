package com.yuejin66.springframework.test.aop;

import com.yuejin66.springframework.test.aop.interceptor.UserServiceInterceptor;
import com.yuejin66.springframework.test.aop.bean.user.UserService;
import com.yuejin66.springframework.test.aop.bean.user.UserServiceImpl;
import com.yuejin66.springframework.test.ioc.bean.customer.CustomerService;
import main.java.com.yuejin66.springframework.aop.AdvisedSupport;
import main.java.com.yuejin66.springframework.aop.TargetSource;
import main.java.com.yuejin66.springframework.aop.aspectj.AspectJExpressionPointcut;
import main.java.com.yuejin66.springframework.aop.framework.Cglib2AopProxy;
import main.java.com.yuejin66.springframework.aop.framework.JdkDynamicAopProxy;
import main.java.com.yuejin66.springframework.context.ApplicationContext;
import main.java.com.yuejin66.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author lyj
 */
public class ApiTest {

    @Test
    public void test_isMatch() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut(
                "execution(* com.yuejin66.springframework.test.aop.bean.user.UserService.*(..))");
        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));         // true
        System.out.println(pointcut.matches(method, clazz)); // true
    }

    @Test
    public void test_dynamic() {
        // 目标对象
        UserService userService = new UserServiceImpl();

        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.yuejin66.springframework.test.aop.bean.user.UserService.*(..))"));

        // 代理对象（JdkDynamicAopProxy）
        UserService proxy_jdk = (UserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象（Cglib2AopProxy）
        UserService proxy_cglib = (UserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy_cglib.register("Joker"));
    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
