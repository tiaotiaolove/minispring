package com.xiaobai.minispring.test.v1;

import com.xiaobai.minispring.core.io.ClassPathResource;
import com.xiaobai.minispring.core.io.FileSystemResource;
import com.xiaobai.minispring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 资源测试
 * @author bail
 * @date 2019/4/2
 */
public class ResourseTest {

    @Test
    public void testClassPathResource() throws Exception {
        Resource r = new ClassPathResource("test.xml");
        assertInputStreamNotNull(r);
    }

    @Test
    public void testFileSystemResource() throws Exception {
        Resource r = new FileSystemResource(System.getProperty("user.dir") + File.separator + "src" + File.separator
                + "test" + File.separator + "resources" + File.separator + "test.xml");
        assertInputStreamNotNull(r);
    }

    private void assertInputStreamNotNull(Resource r) throws IOException {
        InputStream is = null;
        try {
            is = r.getInputStream();
            // 注意：这个测试其实并不充分！！
            Assert.assertNotNull(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
