package com.xiaobai.minispring.beans.factory;

import com.xiaobai.minispring.beans.BeansException;

/**
 * Bean定义存储自定义异常
 * @author bail
 * @date 2019/3/25
 */
public class BeanDefinitionStoreException extends BeansException {

    public BeanDefinitionStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
