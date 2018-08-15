package com.forwechat.wechatproject.controller;

import com.forwechat.wechatproject.pojo.UserInfos;
import com.forwechat.wechatproject.service.common.UserInfosService;
import com.forwechat.wechatproject.utils.R;
import org.json.JSONObject;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public R get(){
        List<UserInfos> userList = userInfosService.list();
        return R.okData(userList);
    }

    /**
     * 根据手机号或用户Id登录
     * **/
    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public R login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //创建session对象
            HttpSession session = request.getSession();
            String a =request.getParameter("userName");
            String b =request.getParameter("passWord");

            UserInfos user  = userInfosService.selectByUserName(request.getParameter("userName"));
            if(user==null){
                return R.error("登录失败，用户名不存在");
            }
            String password = user.getPassWord();

            String loginPassword = request.getParameter("passWord");
            if(!password.equals(loginPassword) ){
                return R.error("登录失败，用户密码错误");
            }

            //把用户数据保存在session域对象中
            session.setAttribute("userName", user.getUserName());

            Cookie cookie = new Cookie("userName",user.getUserName());
            Cookie cookies = new Cookie("passWord",user.getPassWord());
            cookie.setMaxAge(60*60*24*7);   //- 单位为秒，7天有效
            cookies.setPath("/");//- 根路径cookie.setMaxAge(60*60*24*7);   //- 单位为秒，7天有效
            cookies.setPath("/");//- 根路径

            response.setContentType("textml;charset=UTF-8");
            response.addCookie(cookie);
            response.addCookie(cookies);

            return R.okData(user);
    }
}
