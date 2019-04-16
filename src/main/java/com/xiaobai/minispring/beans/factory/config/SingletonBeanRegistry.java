package com.xiaobai.minispring.beans.factory.config;

/**
 * 单例Bean注册类
 *
 * @author bail
 */
public interface SingletonBeanRegistry {
	
	void registerSingleton(String beanName, Object singletonObject);
	
	Object getSingleton(String beanName);
}
