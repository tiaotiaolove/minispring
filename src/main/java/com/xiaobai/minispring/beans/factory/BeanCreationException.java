package com.xiaobai.minispring.beans.factory;

import com.xiaobai.minispring.beans.BeansException;

/**
 * 创建Bean自定义异常
 * @author bail
 * @date 2019/3/25
 */
public class BeanCreationException extends BeansException {
    private String beanName;
    public BeanCreationException(String msg) {
        super(msg);

    }
    public BeanCreationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BeanCreationException(String beanName, String msg) {
        super("Error creating bean with name '" + beanName + "': " + msg);
        this.beanName = beanName;
    }

    public BeanCreationException(String beanName, String msg, Throwable cause) {
        this(beanName, msg);
        initCause(cause);
    }

    public String getBeanName(){
        return this.beanName;
    }
}
