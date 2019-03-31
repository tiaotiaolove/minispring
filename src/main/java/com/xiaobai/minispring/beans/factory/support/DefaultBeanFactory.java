package com.xiaobai.minispring.beans.factory.support;

import com.xiaobai.minispring.beans.BeanDefinition;
import com.xiaobai.minispring.beans.BeanFactory;
import com.xiaobai.minispring.beans.factory.BeanCreationException;
import com.xiaobai.minispring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的Bean工厂
 * @author bail
 * @date 2019/3/21
 */
public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {
    /** 存储多个Bean的定义描述(key为beanId, value为BeadDefinition) */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public DefaultBeanFactory() {}

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return beanDefinitionMap.get(beanId);
    }

    @Override
    public void registerBeanDefinition(String beanID, BeanDefinition bd) {
        this.beanDefinitionMap.put(beanID, bd);
    }

    @Override
    public Object getBean(String beanId) {
        BeanDefinition bd = beanDefinitionMap.get(beanId);
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        try {
            // 通过反射,创建bean的实例
            Class c = cl.loadClass(bd.getBeanClassName());
            return c.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for "+ bd.getBeanClassName() +" failed",e);
        }
    }
}
