package main.java.top.liyuejin.springframework.utils;

/**
 * @author tom lee
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (null == classLoader) {
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
