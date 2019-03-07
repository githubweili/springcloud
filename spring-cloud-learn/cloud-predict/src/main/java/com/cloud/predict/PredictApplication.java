package com.cloud.predict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wei.li
 * on 2019/3/4
 */

@SpringBootApplication
@RestController
public class PredictApplication {

    public static void main(String[] args) {
        SpringApplication.run(PredictApplication.class, args);
    }


}
