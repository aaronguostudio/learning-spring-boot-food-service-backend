package com.imooc.sell.utils;

import java.util.Random;

public class KeyUtil {
    // 生成唯一的主键
    // Add synchronized to avoid generating repeated key in high concurrency situation
    public static synchronized String genUniqueKey() {
        // Generate a six digits 0 - 999999
        Random random = new Random();
        return System.currentTimeMillis() + String.valueOf(random.nextInt(900000) + 100000);
    }
}
