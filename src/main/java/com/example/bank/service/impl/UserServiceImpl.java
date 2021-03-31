package com.example.bank.service.impl;

import com.example.bank.dao.UserMapper;
import com.example.bank.entity.User;
import com.example.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public int save(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode("123".trim());
        user.setPassword(encodedPassword);
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> getList() {
        return userMapper.selectAll();
    }
}
