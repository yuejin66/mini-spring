package com.yuejin66.springframework.test.aop.advice;

import main.java.com.yuejin66.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author lyj
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
