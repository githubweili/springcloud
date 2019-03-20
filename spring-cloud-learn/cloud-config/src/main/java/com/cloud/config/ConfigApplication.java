package com.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wei.li
 * on 2019/2/27
 */

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class  ConfigApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
