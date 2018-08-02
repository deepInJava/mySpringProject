package com.forwechat.wechatproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.forwechat.wechatproject.pojo.UserInfo;

@Mapper
public interface UserInfoDao {
    int insert(@Param("userInfo") UserInfo userInfo);

    int insertSelective(@Param("userInfo") UserInfo userInfo);

    int insertList(@Param("userInfos") List<UserInfo> userInfos);

    int update(@Param("userInfo") UserInfo userInfo);

    List<UserInfo> list();
}
