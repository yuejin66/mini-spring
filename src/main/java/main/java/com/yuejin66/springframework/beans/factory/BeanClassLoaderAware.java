package main.java.com.yuejin66.springframework.beans.factory;

/**
 * 实现此接口，就能感知到所属的 BeanFactory
 *
 * @author lyj
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}
