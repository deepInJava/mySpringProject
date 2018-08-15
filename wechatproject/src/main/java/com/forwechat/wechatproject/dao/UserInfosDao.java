package com.forwechat.wechatproject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.forwechat.wechatproject.pojo.UserInfos;

@Mapper
public interface UserInfosDao {
    int insert(@Param("userInfos") UserInfos userInfos);

    int insertSelective(@Param("userInfos") UserInfos userInfos);

    int insertList(@Param("userInfoss") List<UserInfos> userInfoss);

    int update(@Param("userInfos") UserInfos userInfos);

    List<UserInfos> list();

    UserInfos selectByUserName(String userName);
}
