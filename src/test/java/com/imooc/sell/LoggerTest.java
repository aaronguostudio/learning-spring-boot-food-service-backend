package com.imooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {


    // @Slf4j 是来自 lombok 这个小工具，可以简化配置，比如
    // LoggerFactory.getLogger(LoggerTest.class); 我们不需要每次都
    // 声明：LoggerTest.class

    // private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
        // 系统的默认日志输出级别是 info, 所以 debug 默认不显示
        /*logger.debug("debug");
        logger.info("info");
        logger.error("error");*/

        // Logback 的配置
        // application.yml 适合比较简单的配置
        // logback-spring.xml
        // 比如我们需要：
        // - 区分 info 和 error 日志
        // - 每天产生一个日志文件

        String name = "imooc";
        String password = "123456";

        // 因为使用了 @Slf4j 所以可是直接使用 log
        log.debug("Debug... name: {}, password: {}", name, password);
        log.info("Info... name: {}, passwprd: {}", name, password);
        log.error("Error...");
    }
}
