package com.forwechat.wechatproject.dao.token;

import com.forwechat.wechatproject.pojo.token.TokenEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Token
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:22:07
 */
public interface ApiTokenMapper{

    TokenEntity queryByUserId(@Param("userId") Long userId);

    TokenEntity queryByToken(@Param("token") String token);

    int save(TokenEntity tokenEntity);

    int update(TokenEntity tokenEntity);

}
