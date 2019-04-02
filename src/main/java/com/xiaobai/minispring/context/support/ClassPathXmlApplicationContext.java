package com.xiaobai.minispring.context.support;

import com.xiaobai.minispring.core.io.ClassPathResource;
import com.xiaobai.minispring.core.io.Resource;

/**
 * classPathXml应用上下文
 * @author bail
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	public ClassPathXmlApplicationContext(String classPathFile) {
		super(classPathFile);
	}

    @Override
    public Resource getResourceByPath(String file) {
        return new ClassPathResource(file, this.getBeanClassLoader());
    }
}
