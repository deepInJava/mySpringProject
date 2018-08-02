package com.forwechat.wechatproject.repository.system;


import com.forwechat.wechatproject.pojo.system.User;

public interface UserRepository extends BaseRepository<User,Long>{
    User findByName(String name);
}
