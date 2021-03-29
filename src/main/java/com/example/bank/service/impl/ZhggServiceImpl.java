package com.example.bank.service.impl;

import com.example.bank.dao.YhkxMapper;
import com.example.bank.dao.ZhggMapper;
import com.example.bank.entity.Yhkx;
import com.example.bank.entity.Zhgg;
import com.example.bank.service.YhkxService;
import com.example.bank.service.ZhggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhggServiceImpl implements ZhggService {
    @Autowired
    ZhggMapper zhggMapper;
    @Override
    public List<Zhgg> getList() {
        return zhggMapper.selectAll();
    }

    @Override
    public int save(Zhgg zhgg) {
        return zhggMapper.insertSelective(zhgg);
    }

    @Override
    public int delete(String id) {
        return zhggMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Zhgg zhgg) {
        return zhggMapper.updateByPrimaryKeySelective(zhgg);
    }

    @Override
    public Zhgg getDetail(String id) {
        return zhggMapper.selectByPrimaryKey(id);
    }
}
