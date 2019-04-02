package com.xiaobai.minispring.test.v1;

import com.xiaobai.minispring.context.ApplicationContext;
import com.xiaobai.minispring.context.support.ClassPathXmlApplicationContext;
import com.xiaobai.minispring.context.support.FileSystemXmlApplicationContext;
import com.xiaobai.minispring.service.v1.TestService;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class ApplicationContextTest {

	@Test
	public void testGetBeanFromClassPathContext() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("test.xml");
		TestService testService = (TestService)ctx.getBean("test");
		Assert.assertNotNull(testService);
	}

    @Test 
	public void testGetBeanFromFileSystemContext(){
		ApplicationContext ctx = new FileSystemXmlApplicationContext(System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "test" + File.separator + "resources" + File.separator + "test.xml");
		TestService testService = (TestService)ctx.getBean("test");
		Assert.assertNotNull(testService);
	}

}
