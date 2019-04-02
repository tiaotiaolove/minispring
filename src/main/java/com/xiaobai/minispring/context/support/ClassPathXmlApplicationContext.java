package com.xiaobai.minispring.context.support;

import com.xiaobai.minispring.beans.factory.support.DefaultBeanFactory;
import com.xiaobai.minispring.beans.factory.xml.XmlBeanDefinitionReader;
import com.xiaobai.minispring.context.ApplicationContext;
import com.xiaobai.minispring.core.io.ClassPathResource;
import com.xiaobai.minispring.core.io.Resource;

/**
 * classPathXml应用上下文
 * @author bail
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
	private DefaultBeanFactory factory = null;

	public ClassPathXmlApplicationContext(String configFile) {
		this.factory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this.factory);
		Resource r = new ClassPathResource(configFile);
		reader.loadBeanDefinitions(r);
	}

	@Override
	public Object getBean(String name) {
		return this.factory.getBean(name);
	}
}
