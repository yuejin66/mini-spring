package main.java.top.liyuejin.springframework.beans.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author tom lee
 *
 * 资源加载接口
 *
 * 实现三种不同的流文件操作：classPath、FileSystem、URL
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
