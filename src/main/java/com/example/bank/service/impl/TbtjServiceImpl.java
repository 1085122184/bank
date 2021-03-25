package com.example.bank.service.impl;

import com.example.bank.dao.TbtjMapper;
import com.example.bank.entity.Tbtj;
import com.example.bank.service.TbtjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbtjServiceImpl implements TbtjService {
    @Autowired
    TbtjMapper tbtjMapper;
    @Override
    public List<Tbtj> getList() {
        return tbtjMapper.selectAll();
    }
}
