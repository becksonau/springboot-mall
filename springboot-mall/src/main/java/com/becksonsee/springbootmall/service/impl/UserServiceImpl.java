package com.becksonsee.springbootmall.service.impl;

import com.becksonsee.springbootmall.dao.UserDao;
import com.becksonsee.springbootmall.dto.UserRegisterRequest;
import com.becksonsee.springbootmall.model.User;
import com.becksonsee.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}