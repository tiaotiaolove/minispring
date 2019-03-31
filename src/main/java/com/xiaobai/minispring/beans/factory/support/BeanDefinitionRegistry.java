package com.xiaobai.minispring.beans.factory.support;

import com.xiaobai.minispring.beans.BeanDefinition;

/**
 * Bean定义注册与获取接口
 * @author bail
 */
public interface BeanDefinitionRegistry {
	/**
	 * 根据beanID获取 bean定义类
	 * @param beanID beanID
	 * @return bean定义类
	 */
	BeanDefinition getBeanDefinition(String beanID);

	/**
	 * 注册Bean定义
	 * @param beanID beanID
	 * @param bd bean定义
	 */
	void registerBeanDefinition(String beanID, BeanDefinition bd);
}
