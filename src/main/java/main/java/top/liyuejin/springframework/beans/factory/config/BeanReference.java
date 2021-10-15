package main.java.top.liyuejin.springframework.beans.factory.config;

/**
 * 类引用
 *
 * @author lyj
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    /* get/set */

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
