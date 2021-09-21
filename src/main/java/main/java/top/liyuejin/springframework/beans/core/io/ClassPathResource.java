package main.java.top.liyuejin.springframework.beans.core.io;

import main.java.top.liyuejin.springframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tom lee
 *
 * 通过 ClassLoader 来读取 ClassPath 下的文件信息
 */
public class ClassPathResource implements Resource{

    private final String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (null != classLoader ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(path);
        if (null == inputStream) {
            throw new FileNotFoundException(this.path +
                    "cannot be opened because it does not exist");
        }
        return inputStream;
    }
}
