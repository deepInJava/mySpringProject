package com.forwechat.wechatproject.service.common.impl;

import com.forwechat.wechatproject.pojo.UserInfo;
import com.forwechat.wechatproject.service.common.UserInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.forwechat.wechatproject.dao.UserInfoDao;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public int insert(UserInfo userInfo){
        return userInfoDao.insert(userInfo);
    }

    @Override
    public int insertSelective(UserInfo userInfo){
        return userInfoDao.insertSelective(userInfo);
    }

    @Override
    public int insertList(List<UserInfo> userInfos){
        return userInfoDao.insertList(userInfos);
    }

    @Override
    public int update(UserInfo userInfo){
        return userInfoDao.update(userInfo);
    }

    @Override
    public List<UserInfo> list() {
        return userInfoDao.list();
    }
}
