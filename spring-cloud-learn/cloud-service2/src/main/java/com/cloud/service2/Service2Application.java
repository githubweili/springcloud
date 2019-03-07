package com.cloud.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wei.li
 * on 2019/2/27
 */

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Service2Application {


    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }


    @RequestMapping(value = "hello")
    public String hello(@RequestParam(value = "name", defaultValue = "2") String name){
        return "hello, 2";
    }
}
