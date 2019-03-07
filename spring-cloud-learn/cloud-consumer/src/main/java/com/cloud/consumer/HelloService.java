package com.cloud.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by wei.li
 * on 2019/2/26
 */

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String hello(String name){
        return restTemplate.getForObject("http://CLOUD-SERVICE/hello?name="+name, String.class);
    }

    public String error(String name){
        return "sorry, error";
    }
}

