package com.xiaobai.minispring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源抽象接口
 * @author bail
 * @date 2019/4/2
 */
public interface Resource {
    InputStream getInputStream() throws IOException;

    String getDescription();
}
