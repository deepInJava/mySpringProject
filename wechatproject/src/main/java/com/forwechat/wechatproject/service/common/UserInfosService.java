package com.forwechat.wechatproject.service.common;

import java.util.List;
import com.forwechat.wechatproject.pojo.UserInfos;
public interface UserInfosService{

    int insert(UserInfos userInfos);

    int insertSelective(UserInfos userInfos);

    int insertList(List<UserInfos> userInfoss);

    int update(UserInfos userInfos);

    List<UserInfos> list();

    UserInfos selectByUserName(String userName);
}
