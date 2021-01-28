package com.tingle;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/18/20:35
 * @Description:
 */
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2Doc
@EnableAsync
public class UserApp {
    
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class);
    }
}
