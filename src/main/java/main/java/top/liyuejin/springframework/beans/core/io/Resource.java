package main.java.top.liyuejin.springframework.beans.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载接口
 *
 * 实现三种不同的流文件操作：classPath、FileSystem、URL
 *
 * @author tom lee
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
