package com.xiaobai.minispring.beans;

/**
 * bean定义接口
 * @author bail
 * @date 2019/3/21
 */
public interface BeanDefinition {
    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT = "";

    /**
     * 获取bean类名
     * @return bean类名
     */
    String getBeanClassName();

    boolean isSingleton();

    boolean isPrototype();

    String getScope();

    void setScope(String scope);
}
