package main.java.top.liyuejin.springframework.beans.core.io;

/**
 * @author tom lee
 *
 * 包资源加载器
 *
 * 根据资源加载的不同方式，资源加载器可以把这些（classPath、FileSystem、URL...）方式，
 * 集中到统一的类服务下进行处理，外部用户只需要传递资源地址即可，简化使用。
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
