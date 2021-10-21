package main.java.top.liyuejin.springframework.beans.factory;

/**
 * 实现此接口，就能感知到所属的 BeanName
 *
 * @author lyj
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String beanName);
}
