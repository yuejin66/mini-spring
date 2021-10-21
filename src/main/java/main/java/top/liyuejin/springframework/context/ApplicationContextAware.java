package main.java.top.liyuejin.springframework.context;

import main.java.top.liyuejin.springframework.beans.BeansException;
import main.java.top.liyuejin.springframework.beans.factory.Aware;

/**
 * 实现此接口，就能感知到所属的 ApplicationContext
 *
 * @author lyj
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
