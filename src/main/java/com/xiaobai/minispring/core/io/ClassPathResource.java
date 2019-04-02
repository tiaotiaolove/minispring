package com.xiaobai.minispring.core.io;

import com.xiaobai.minispring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * classPath获取资源
 * @author bail
 * @date 2019/4/2
 */
public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = this.classLoader.getResourceAsStream(this.path);
        if (is == null) {
            throw new FileNotFoundException(path + " cannot be opened");
        }
        return is;

    }

    @Override
    public String getDescription(){
        return this.path;
    }
}
