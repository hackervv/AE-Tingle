package com.tingle.api.h5.service;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/04/22:49
 * @Description:
 */
@SpringBootApplication
@EnableSwagger2Doc
public class H5AppStart {
    public static void main(String[] args) {
        SpringApplication.run(H5AppStart.class);
    }
}
