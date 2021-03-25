/*
 * Copyright (C) 2021 	北京中文在线数字出版集团
 * 
 * @Version: Version 0.1	@see <http://www.col.com>
 * 
 * @Date: 2021-3-25
 * 
 * @Author: Li xiaolei (lixl@col.com) 
 */
package com.ray.sentinel.setting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixiaolei
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelSettingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelSettingApplication.class);
    }

    @RestController
    @RefreshScope
    public class ConfigClass {
        @Value("${user.name}")
        private String userName;

        @GetMapping("/hi")
        public String hi() {
            return "hi " + userName;
        }
    }
}
