package com.forwechat.wechatproject.service.common.impl;

import com.forwechat.wechatproject.pojo.UserInfos;
import com.forwechat.wechatproject.service.common.UserInfosService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.forwechat.wechatproject.dao.UserInfosDao;

@Service
public class UserInfosServiceImpl implements UserInfosService {

    @Resource
    private UserInfosDao userInfosDao;

    @Override
    public int insert(UserInfos userInfos){
        return userInfosDao.insert(userInfos);
    }

    @Override
    public int insertSelective(UserInfos userInfos){
        return userInfosDao.insertSelective(userInfos);
    }

    @Override
    public int insertList(List<UserInfos> userInfoss){
        return userInfosDao.insertList(userInfoss);
    }

    @Override
    public int update(UserInfos userInfos){
        return userInfosDao.update(userInfos);
    }

    @Override
    public List<UserInfos> list() {
        return userInfosDao.list();
    }

    @Override
    public UserInfos selectByUserName(String userName) {
        return userInfosDao.selectByUserName(userName);
    }
}
