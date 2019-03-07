package com.cloud.consumer.feign;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by wei.li
 * on 2019/2/26
 */

@FeignClient(value = "cloud-zuul", fallback = HelloServiceHystric.class)
public interface IHelloService {

    @RequestMapping(value = "api-a/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name);
}
