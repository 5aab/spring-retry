package com.aab.retry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;


@SpringBootApplication
@EnableRetry
public class RetryTemplateApplication {

    public static void main(String[] args){
        SpringApplication.run(RetryTemplateApplication.class, args);
    }

}
