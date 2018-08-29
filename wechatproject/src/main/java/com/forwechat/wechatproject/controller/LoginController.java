package com.forwechat.wechatproject.controller;

import com.forwechat.wechatproject.pojo.UserInfos;
import com.forwechat.wechatproject.pojo.WeChatSession;
import com.forwechat.wechatproject.service.common.UserInfosService;
import com.forwechat.wechatproject.utils.R;
import com.google.gson.Gson;
import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserInfosService userInfosService;


    @ResponseBody
    @RequestMapping(value = "lists", method = RequestMethod.GET)
    public R get(){
        List<UserInfos> userList = userInfosService.list();
        return R.okData(userList);
    }

    private static final long serialVersionUID = 1L;

    private static final String APPID = "wxcce6f163c8cd6a88";
    private static final String SECRET = "63f2926a6727bc4f7c1ee442080dadb5";

    //获取凭证校检接口
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public R login(String code) {
        //R result=new R();
        //微信的接口
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID +
                "&secret=" + SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        //进行网络请求,访问url接口
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        //根据返回值进行后续操作
        if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
            String sessionData = responseEntity.getBody();
            Gson gson = new Gson();
            //解析从微信服务器获得的openid和session_key;
            WeChatSession weChatSession = gson.fromJson(sessionData, WeChatSession.class);
            //获取用户的唯一标识
            String openid = weChatSession.getOpenid();
            //获取会话秘钥
            String session_key = weChatSession.getSession_key();
            //下面就可以写自己的业务代码了
            //最后要返回一个自定义的登录态,用来做后续数据传输的验证
            return R.okData(weChatSession);
        }
        return R.error("获取token失败");
    }


    //获取凭证校检接口
    @ResponseBody
    @RequestMapping(value = "loginPrivate", method = RequestMethod.POST)
    public R loginPrivate(@RequestBody UserInfos userInfos) {
        String username = userInfos.getUserName();
        String password = userInfos.getPassWord();
        UserInfos user = userInfosService.selectByUserName(userInfos.getUserName());
        if(user==null){
            return R.error("查询不到用户信息");
        }
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }

        return R.okData(user);
    }

    //获取凭证校检接口
    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public R list() {
        SecurityManager securityManager=SecurityUtils.getSecurityManager();
        Subject subject = SecurityUtils.getSubject();
        List<UserInfos> userList = userInfosService.list();
        return R.okData(userList);
    }

}
