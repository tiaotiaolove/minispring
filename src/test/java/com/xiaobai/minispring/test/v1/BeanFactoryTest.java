package com.xiaobai.minispring.test.v1;

import com.xiaobai.minispring.beans.BeanDefinition;
import com.xiaobai.minispring.beans.BeanFactory;
import com.xiaobai.minispring.beans.factory.support.DefaultBeanFactory;
import com.xiaobai.minispring.service.v1.TestService;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author bail
 * @date 2019/3/21
 */
public class BeanFactoryTest {
    @Test
    public void testGetBean() {
        BeanFactory beanFactory = new DefaultBeanFactory("test.xml");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("test");
        assertEquals("", beanDefinition.getBeanClassName());
        TestService testService = (TestService)beanFactory.getBean("test");
        assertNotNull(testService);
    }
}