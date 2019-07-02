package com.imooc.sell.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// 采用环境变量，下面一行是使用配置文件的方式
//@ConfigurationProperties(prefix = "wechat")
@Data
@Component
public class WechatAccountConfig {
    @Value("${mpAppId}")
    private String mpAppId;

    @Value("${mpAppSecret}")
    private String mpAppSecret;
}
