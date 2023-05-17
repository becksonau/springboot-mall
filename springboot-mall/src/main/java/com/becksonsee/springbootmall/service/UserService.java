package com.becksonsee.springbootmall.service;

import com.becksonsee.springbootmall.dto.UserLoginRequest;
import com.becksonsee.springbootmall.dto.UserRegisterRequest;
import com.becksonsee.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);


}
