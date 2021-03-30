package com.example.bank.service.impl;

import com.example.bank.dao.UserMapper;
import com.example.bank.entity.User;
import com.example.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByUserName(String username) {
        return userMapper.selectByUserName(username);
    }
}
