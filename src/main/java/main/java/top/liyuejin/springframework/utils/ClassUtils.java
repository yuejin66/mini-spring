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

    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (null != clazz && isCglibProxyClassName(clazz.getName()));
    }

    public static boolean isCglibProxyClassName(String className) {
        return (null != className && className.contains("&&"));
    }
}
