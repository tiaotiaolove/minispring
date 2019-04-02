package com.xiaobai.minispring.context.support;

import com.xiaobai.minispring.beans.factory.support.DefaultBeanFactory;
import com.xiaobai.minispring.beans.factory.xml.XmlBeanDefinitionReader;
import com.xiaobai.minispring.context.ApplicationContext;
import com.xiaobai.minispring.core.io.Resource;
import com.xiaobai.minispring.util.ClassUtils;

/**
 * 典型的模板方法 - 设计模式
 *   抽象出父类(抽象类)
 *   实现一个模板方法
 *   将需要不同实现的方法抽象出来,让子类继承重写
 * @author bail
 * @date 2019/4/2
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    private DefaultBeanFactory factory;
    private ClassLoader beanClassLoader;

    public AbstractApplicationContext(String file) {
        this.factory = new DefaultBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this.factory);
        // 调用子类重写的方法(这样就可以去除子类中可能出现的重复代码)
        Resource r = getResourceByPath(file);
        reader.loadBeanDefinitions(r);
        factory.setBeanClassLoader(this.getBeanClassLoader());
    }

    /**
     * 需要被子类重写的方法
     * @param file
     * @return
     */
    public abstract Resource getResourceByPath(String file);

    @Override
    public Object getBean(String name) {
        return this.factory.getBean(name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = beanClassLoader;
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return (this.beanClassLoader != null ? this.beanClassLoader : ClassUtils.getDefaultClassLoader());
    }
}
