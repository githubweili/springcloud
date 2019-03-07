package com.cloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wei.li
 * on 2019/2/26
 */

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "forwei") String name){
        return "hello" + name + ", i am from port:" + port;
    }

}
