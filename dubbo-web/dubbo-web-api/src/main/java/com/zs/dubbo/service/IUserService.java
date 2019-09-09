package com.zs.dubbo.service;

import java.util.Map;

/**
 * @Company
 * @Author Zs
 * @Date Create in 2019/9/7
 **/
public interface IUserService {

    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username
     * @param password
     * @return
     */
    Map<String, Object> selectByUsernameAndPassword(String username, String password);
}
