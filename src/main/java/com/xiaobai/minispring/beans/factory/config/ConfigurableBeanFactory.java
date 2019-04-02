package com.xiaobai.minispring.beans.factory.config;

import com.xiaobai.minispring.beans.BeanFactory;

/**
 * 配置BeanFactory的类
 *   目前用来设置Bean的ClassLoader
 * @author bail
 */
public interface ConfigurableBeanFactory extends BeanFactory {

	void setBeanClassLoader(ClassLoader beanClassLoader);

	ClassLoader getBeanClassLoader();	
}
