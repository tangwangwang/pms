package com.fyj.pms.service;

import com.fyj.pms.entity.User;
import com.fyj.pms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-08-22 14:54
 * @name com.fyj.pms.service.UserService.java
 * @see describing
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUser(User user) {
        return userMapper.findByUsernameAndPassword(user);
    }

}
