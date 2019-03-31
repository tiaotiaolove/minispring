package com.xiaobai.minispring.beans;

/**
 * bean工厂接口
 * @author bail
 * @date 2019/3/21
 */
public interface BeanFactory {

    /**
     * 根据bean名称获取类
     * @param name bean名称
     * @return 类
     */
    Object getBean(String name);
}
