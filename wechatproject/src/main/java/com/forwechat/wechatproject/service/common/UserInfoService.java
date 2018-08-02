package com.forwechat.wechatproject.service.common;

import java.util.List;
import com.forwechat.wechatproject.pojo.UserInfo;
public interface UserInfoService{

    int insert(UserInfo userInfo);

    int insertSelective(UserInfo userInfo);

    int insertList(List<UserInfo> userInfos);

    int update(UserInfo userInfo);

    List<UserInfo> list();
}
