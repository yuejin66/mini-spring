package main.java.com.yuejin66.springframework.aop;

/**
 * @author lyj
 */
public interface ClassFilter {

    /**
     * 定义类匹配类，用于切点找到给定的接口和目标类。
     *
     * @param clazz Class 类
     * @return      boolean
     */
    boolean matches(Class<?> clazz);
}
