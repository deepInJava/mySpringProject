package com.forwechat.wechatproject.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfos implements Serializable {
    private Long id;//主键
    private String userName;//系统名称
    private String name;//真实名称
    private String telephone;//手机号
    private String passWord;//登录密码
    private String email;//邮箱
    private Long stat;//是否可用
    private String sex;//性别
    private String loginIp;//登录ip
    private Date loginTime;
    private String address;//居住地址
    private String  identityCard;//身份证
    private String identityCardAddress;//身份证地址

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getStat() {
        return stat;
    }

    public void setStat(Long stat) {
        this.stat = stat;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIdentityCardAddress() {
        return identityCardAddress;
    }

    public void setIdentityCardAddress(String identityCardAddress) {
        this.identityCardAddress = identityCardAddress;
    }
}
