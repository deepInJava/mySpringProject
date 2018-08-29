package com.forwechat.wechatproject.config.system;

import com.forwechat.wechatproject.pojo.UserInfos;
import com.forwechat.wechatproject.service.common.UserInfosService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthRealm extends AuthorizingRealm{
    @Autowired
    private UserInfosService userInfosService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        UserInfos user=(UserInfos) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        /*List<String> permissions=new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(roles.size()>0) {
            for(Role role : roles) {
                Set<Module> modules = role.getModules();
                if(modules.size()>0) {
                    for(Module module : modules) {
                        permissions.add(module.getMname());
                    }
                }
            }
        }*/
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        UserInfos user = userInfosService.selectByUserName(username);
        return new SimpleAuthenticationInfo(user, user.getPassWord(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
}
