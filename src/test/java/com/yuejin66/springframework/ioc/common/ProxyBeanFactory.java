package com.yuejin66.springframework.ioc.common;

import main.java.com.yuejin66.springframework.beans.factory.FactoryBean;
import com.yuejin66.springframework.ioc.bean.student.StudentDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author yuejin66
 */
public class ProxyBeanFactory implements FactoryBean<StudentDao> {

    @Override
    public StudentDao getObject() throws Exception {
        InvocationHandler handler = ((proxy, method, args) -> {
            HashMap<String, String> map = new HashMap<>();
            map.put("10001", "客户A");
            map.put("10002", "客户B");
            map.put("10003", "客户C");
            return "你被代理啦 " + method.getName() + "：" + map.get(args[0].toString());
        });
        return (StudentDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{StudentDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return StudentDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
