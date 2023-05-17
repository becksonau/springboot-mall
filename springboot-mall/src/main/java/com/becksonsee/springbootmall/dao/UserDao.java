package com.becksonsee.springbootmall.dao;

import com.becksonsee.springbootmall.dto.UserRegisterRequest;
import com.becksonsee.springbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);
}
