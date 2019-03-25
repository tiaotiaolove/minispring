package com.xiaobai.minispring.beans.factory.support;

import com.xiaobai.minispring.beans.BeanDefinition;
import com.xiaobai.minispring.beans.BeanFactory;
import com.xiaobai.minispring.beans.factory.BeanCreationException;
import com.xiaobai.minispring.beans.factory.BeanDefinitionStoreException;
import com.xiaobai.minispring.util.ClassUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bail
 * @date 2019/3/21
 */
public class DefaultBeanFactory implements BeanFactory {
    /** xml中id属性 */
    private static final String ID_ATTRIBUTE = "id";
    /** xml中class属性 */
    private static final String CLASS_ATTRIBUTE = "class";
    /** key为beanId,value为BeadDefinition */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    public DefaultBeanFactory(String configFile) {
        // new 工厂时,加载xml配置文件
        loadBeanDefinitions(configFile);
    }

    /**
     * 根据beanId获取bean定义
     * @param beanId bean标识
     * @return bean定义
     */
    public BeanDefinition getBeanDefinition(String beanId) {
        return beanDefinitionMap.get(beanId);
    }

    public Object getBean(String beanId) {
        BeanDefinition bd = beanDefinitionMap.get(beanId);
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        try {
            Class c = cl.loadClass(bd.getBeanClassName());
            return c.newInstance();
        } catch (Exception e) {
            throw new BeanCreationException("create bean for "+ bd.getBeanClassName() +" failed",e);
        }
    }

    public void loadBeanDefinitions(String configFile){
        InputStream is = null;
        try{
            ClassLoader cl = ClassUtils.getDefaultClassLoader();
            is = cl.getResourceAsStream(configFile);

            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while(iter.hasNext()){
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);
                beanDefinitionMap.put(id, bd);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + configFile,e);
        }finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
