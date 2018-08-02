package com.forwechat.wechatproject.service.system;

import com.forwechat.wechatproject.pojo.system.Role;
import com.forwechat.wechatproject.pojo.system.User;

import java.util.Map;

public interface ILoginService {

    public User addUser(Map<String, Object> map);

    public Role addRole(Map<String, Object> map);

    public User findByName(String name);
}
