package com.xiaobai.minispring.test.v1;

import com.xiaobai.minispring.beans.BeanDefinition;
import com.xiaobai.minispring.beans.factory.BeanCreationException;
import com.xiaobai.minispring.beans.factory.BeanDefinitionStoreException;
import com.xiaobai.minispring.beans.factory.support.DefaultBeanFactory;
import com.xiaobai.minispring.beans.factory.xml.XmlBeanDefinitionReader;
import com.xiaobai.minispring.core.io.ClassPathResource;
import com.xiaobai.minispring.service.v1.TestService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author bail
 * @date 2019/3/21
 */
public class BeanFactoryTest {

    DefaultBeanFactory beanFactory = null;
    XmlBeanDefinitionReader xmlReader = null;

    @Before
    public void setUp(){
        beanFactory = new DefaultBeanFactory();
        xmlReader = new XmlBeanDefinitionReader(beanFactory);
    }

    /**
     * 测试获取Bean类
     */
    @Test
    public void testGetBean() {
        xmlReader.loadBeanDefinitions(new ClassPathResource("test.xml"));
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("test");
        assertEquals("com.xiaobai.minispring.service.v1.TestService", beanDefinition.getBeanClassName());
        TestService testService = (TestService)beanFactory.getBean("test");
        assertNotNull(testService);
    }

    /**
     * 测试获取错误路径的Bean
     */
    @Test
    public void testGetInvalidBean() {
        xmlReader.loadBeanDefinitions(new ClassPathResource("test.xml"));
        try {
            beanFactory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }
        fail("expect BeanCreationException ");
    }

    /**
     * 测试读取错误的xml路径
     */
    @Test
    public void testInvalidXML(){
        try{
            xmlReader.loadBeanDefinitions(new ClassPathResource("xxxx.xml"));
        }catch(BeanDefinitionStoreException e){
            return;
        }
        fail("expect BeanDefinitionStoreException ");
    }
}
