package com.cloud.consumer.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wei.li
 * on 2019/2/27
 */
@Component
public class HelloServiceHystric implements IHelloService {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "feign, error";
    }
}
