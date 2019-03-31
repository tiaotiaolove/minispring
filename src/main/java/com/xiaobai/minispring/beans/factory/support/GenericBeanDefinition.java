package com.xiaobai.minispring.beans.factory.support;

import com.xiaobai.minispring.beans.BeanDefinition;

/**
 * 通用的bean定义类
 * @author bail
 * @date 2019/3/25
 */
public class GenericBeanDefinition implements BeanDefinition {
    private String id;
    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }
}
