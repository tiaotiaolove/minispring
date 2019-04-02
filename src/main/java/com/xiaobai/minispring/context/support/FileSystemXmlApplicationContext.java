package com.xiaobai.minispring.context.support;

import com.xiaobai.minispring.core.io.FileSystemResource;
import com.xiaobai.minispring.core.io.Resource;

/**
 * @author bail
 * @date 2019/4/2
 */
public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

    public FileSystemXmlApplicationContext(String filePath) {
        super(filePath);
    }

    @Override
    public Resource getResourceByPath(String file) {
        return new FileSystemResource(file);
    }
}
