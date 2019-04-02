package com.xiaobai.minispring.util;

/**
 * mini spring内部的Assert
 * @author bail
 * @date 2019/4/2
 */
public class Assert {
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
