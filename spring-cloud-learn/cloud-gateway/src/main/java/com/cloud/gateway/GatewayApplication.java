package com.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by wei.li
 * on 2019/3/4
 */

@SpringBootApplication
@RestController
public class GatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p.
                        path("/hello").
                        filters(f -> f.addRequestHeader("hello", "word"))
                        .uri("http://localhost:8085"))
                .route(p -> p
                        .path("/hello")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri("http://localhost:8085"))
                .build();
    }


    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }
}
