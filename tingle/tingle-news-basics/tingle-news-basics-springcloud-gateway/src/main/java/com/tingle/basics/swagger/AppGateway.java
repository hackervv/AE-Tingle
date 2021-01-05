package com.tingle.basics.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: AppGateway
 * @description: 每特教育独创微服务电商项目
 * @addres www.mayikt.com
 * @date 2020/3/516:55
 */
@SpringBootApplication
public class AppGateway {
    /**
     * Gateway的底层是基于webfux
     * SpringMVC底层基于我们的servet实现
     * Spring-web封装了我们SpringMVC
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(AppGateway.class);
    }
}
