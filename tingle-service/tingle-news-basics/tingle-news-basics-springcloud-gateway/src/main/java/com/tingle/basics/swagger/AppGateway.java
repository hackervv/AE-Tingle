package com.tingle.basics.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ireck
 * @title: AppGateway
 * @date 2020/3/516:55
 */
@SpringBootApplication
public class AppGateway {
    /**
     * The bottom layer of gateway is based on Webflux
     * The bottom layer of spring MVC is based on our server implementation
     * SSpring web encapsulates our spring MVC
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class);
    }
}
