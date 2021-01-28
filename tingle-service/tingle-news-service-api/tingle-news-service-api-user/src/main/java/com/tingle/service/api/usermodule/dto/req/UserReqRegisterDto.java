package com.tingle.service.api.usermodule.dto.req;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/17/15:29
 * @Description:
 */
public class UserReqRegisterDto {

    private String mobile;

    private String passWord;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
