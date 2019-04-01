package com.xiaobai.minispring.test.v1;

import com.xiaobai.minispring.context.ApplicationContext;
import com.xiaobai.minispring.context.support.ClassPathXmlApplicationContext;
import com.xiaobai.minispring.service.v1.TestService;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationContextTest {

	@Test
	public void testGetBean() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test.xml");
		TestService testService = (TestService)ctx.getBean("test");
		Assert.assertNotNull(testService);
	}
    @Test 
	public void testGetBeanFromFileSystemContext(){
		System.out.println(System.getProperty("user.dir"));
	}

}
