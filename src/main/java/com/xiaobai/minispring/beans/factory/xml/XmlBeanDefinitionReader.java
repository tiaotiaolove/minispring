package com.xiaobai.minispring.beans.factory.xml;

import com.xiaobai.minispring.beans.BeanDefinition;
import com.xiaobai.minispring.beans.factory.BeanDefinitionStoreException;
import com.xiaobai.minispring.beans.factory.support.BeanDefinitionRegistry;
import com.xiaobai.minispring.beans.factory.support.GenericBeanDefinition;
import com.xiaobai.minispring.core.io.Resource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * 读取xml类型的Bean定义
 * @author bail
 * @date 2019/3/25
 */
public class XmlBeanDefinitionReader {
    /** xml中id属性 */
    private static final String ID_ATTRIBUTE = "id";
    /** xml中class属性 */
    private static final String CLASS_ATTRIBUTE = "class";
    /** xml中scope属性 */
    private static final String SCOPE_ATTRIBUTE = "scope";

    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry){
        this.registry = registry;
    }

    /**
     * 根据传入文件名,获取Bean定义
     * @param resource 配置文件资源
     */
    public void loadBeanDefinitions(Resource resource){
        InputStream is = null;
        try{
            is = resource.getInputStream();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);

            Element root = doc.getRootElement();
            Iterator<Element> iter = root.elementIterator();
            while(iter.hasNext()){
                Element ele = iter.next();
                String id = ele.attributeValue(ID_ATTRIBUTE);
                String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);
                if (ele.attribute(SCOPE_ATTRIBUTE) != null) {
                    bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
                }
                this.registry.registerBeanDefinition(id, bd);
            }
        } catch (Exception e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document from " + resource.getDescription(),e);
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
