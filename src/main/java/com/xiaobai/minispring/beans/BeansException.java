package com.xiaobai.minispring.beans;

/**
 * Bean相关自定义异常父类
 * @author bail
 * @date 2019/3/25
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
