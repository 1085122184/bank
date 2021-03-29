package com.example.bank.service.impl;

import com.example.bank.dao.YhkxMapper;
import com.example.bank.entity.Yhkx;
import com.example.bank.service.YhkxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YhkxServiceImpl implements YhkxService {
    @Autowired
    YhkxMapper yhkxMapper;
    @Override
    public List<Yhkx> getList() {
        return yhkxMapper.selectAll();
    }

    @Override
    public int save(Yhkx yhkx) {
        return yhkxMapper.insertSelective(yhkx);
    }

    @Override
    public int delete(String id) {
        return yhkxMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Yhkx yhkx) {
        return yhkxMapper.updateByPrimaryKeySelective(yhkx);
    }
}
