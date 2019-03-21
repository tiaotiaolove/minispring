package com.xiaobai.minispring.beans.factory.support;

import com.xiaobai.minispring.beans.BeanDefinition;
import com.xiaobai.minispring.beans.BeanFactory;

/**
 * @author bail
 * @date 2019/3/21
 */
public class DefaultBeanFactory implements BeanFactory {

    public DefaultBeanFactory(String configFile) {
    }

    public BeanDefinition getBeanDefinition(String name) {
        return null;
    }

    public Object getBean(String name) {
        return null;
    }
}
