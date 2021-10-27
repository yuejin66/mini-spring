package main.java.com.yuejin66.springframework.beans.factory.support;

import main.java.com.yuejin66.springframework.beans.BeansException;
import main.java.com.yuejin66.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化 Bean 策略接口
 *
 * 1. JDK 自带的 DeclaredConstructor
 * 2. 基于字节码框架 ASM 实现的 Cglib
 *
 * @author lyj
 */
public interface InstantiationStrategy {

    /**
     * 策略方法
     *
     * @param beanDefinition  bean 定义
     * @param beanName        bean 名字
     * @param constructor     Constrictor类，里面包含了一些必要的类信息，为了拿到符合入参信息相对应的构造函数
     * @param args            入参信息
     * @return 实例化对象
     * @throws BeansException BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName,
                       Constructor<?> constructor, Object[] args) throws BeansException;
}
