package com.tingle.service.impl.entitydo;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/17/16:40
 * @Description:
 */
public class UserDo {
    
    /**
     * userid
     */
    
    private Long userId;
    /**
     * mobile number
     */
    
    private String mobile;
    
    /**
     * email
     */
    private String email;
    
    /**
     * password
     */
    private String passWord;
    
    /**
     * userName
     */
    private String userName;
    
    /**
     * sex 0 man 1woman
     */
    private char sex;
    
    /**
     * age
     */
    private Long age;
    
    /**
     * registerTime
     */
    private Date createTime;
    
    /**
     * updateTime
     */
    private Date updateTime;
    
    /**
     * account is valible 1 normal froze 0
     */
    private char isAvalible;
    
    /**
     * user face
     */
    private String picImg;
    
    /**
     * User associated QQ open ID
     */
    private String qqOpenId;
    
    /**
     * User associated wechart open ID
     */
    private String wxOpenId;
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassWord() {
        return passWord;
    }
    
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public char getSex() {
        return sex;
    }
    
    public void setSex(char sex) {
        this.sex = sex;
    }
    
    public Long getAge() {
        return age;
    }
    
    public void setAge(Long age) {
        this.age = age;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public char getIsAvalible() {
        return isAvalible;
    }
    
    public void setIsAvalible(char isAvalible) {
        this.isAvalible = isAvalible;
    }
    
    public String getPicImg() {
        return picImg;
    }
    
    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }
    
    public String getQqOpenId() {
        return qqOpenId;
    }
    
    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }
    
    public String getWxOpenId() {
        return wxOpenId;
    }
    
    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }
}
