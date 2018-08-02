package com.forwechat.wechatproject.controller;

import com.forwechat.wechatproject.pojo.UserInfo;
import com.forwechat.wechatproject.service.common.UserInfoService;
import com.forwechat.wechatproject.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserInfoService userInfoService;

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public R get(){
        List<UserInfo> userList = userInfoService.list();
        return R.okData(userList);
    }
}
