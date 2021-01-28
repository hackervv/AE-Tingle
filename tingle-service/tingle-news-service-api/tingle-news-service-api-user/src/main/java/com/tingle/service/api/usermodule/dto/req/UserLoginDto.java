package com.tingle.service.api.usermodule.dto.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/17/15:23
 * @Description:
 */
public class UserLoginDto {
    private String mobile;

    private String password;
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
