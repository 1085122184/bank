package com.example.bank.service;


import com.example.bank.entity.User;

import java.util.List;

public interface UserService {
    User getUserByUserName(String username);
    int save(User user);
    List<User> getList();
}
