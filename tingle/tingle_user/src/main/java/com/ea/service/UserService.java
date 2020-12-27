package com.ea.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 顾轩
 * @Date: 2020/12/24/0:02
 * @Description:
 */
@RestController
public class UserService {
    @GetMapping("getUser")
    public String getUser(Integer userId){
        return "ireck";
    }
}
