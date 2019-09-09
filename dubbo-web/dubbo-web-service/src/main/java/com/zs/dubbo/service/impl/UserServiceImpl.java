package com.zs.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zs.dubbo.mapper.UserMapper;
import com.zs.dubbo.model.User;
import com.zs.dubbo.service.IUserService;
import com.zs.dubbo.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Company
 * @Author Zs
 * @Date Create in 2019/9/7
 **/
@Service(timeout = 50000)
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String,Object> selectByUsernameAndPassword(String username, String password) {
        User user = userMapper.selectByUsernameAndPassword(username, password);
        return MapUtil.setResultMap(user);
    }
}
