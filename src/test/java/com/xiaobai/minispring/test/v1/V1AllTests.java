package com.xiaobai.minispring.test.v1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 所有测试用例集合
 *
 * @author bail
 * @date 2019/4/1
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationContextTest.class,
        BeanFactoryTest.class,
        ResourseTest.class
})
public class V1AllTests {

}
