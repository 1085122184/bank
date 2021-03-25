package com.example.bank.service.impl;

import com.example.bank.dao.ZhxwMapper;
import com.example.bank.entity.Zhxw;
import com.example.bank.service.ZhxwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhxwServiceImpl implements ZhxwService {
    @Autowired
    ZhxwMapper zhxwMapper;
    @Override
    public List<Zhxw> getList() {
        return zhxwMapper.selectAll();
    }
}