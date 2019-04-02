package com.xiaobai.minispring.context.support;

import com.xiaobai.minispring.beans.factory.support.DefaultBeanFactory;
import com.xiaobai.minispring.beans.factory.xml.XmlBeanDefinitionReader;
import com.xiaobai.minispring.context.ApplicationContext;
import com.xiaobai.minispring.core.io.FileSystemResource;
import com.xiaobai.minispring.core.io.Resource;

/**
 * @author bail
 * @date 2019/4/2
 */
public class FileSystemXmlApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory = null;

    public FileSystemXmlApplicationContext(String filePath) {
        this.factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this.factory);
        Resource r = new FileSystemResource(filePath);
        reader.loadBeanDefinitions(r);
    }

    @Override
    public Object getBean(String name) {
        return this.factory.getBean(name);
    }
}
