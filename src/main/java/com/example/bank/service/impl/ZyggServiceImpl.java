package com.example.bank.service.impl;

import com.example.bank.dao.ZyggMapper;
import com.example.bank.entity.Zygg;
import com.example.bank.service.ZyggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZyggServiceImpl implements ZyggService {
    @Autowired
    ZyggMapper zyggMapper;
    @Override
    public List<Zygg> getList() {
        return zyggMapper.selectAll();
    }
    @Override
    public List<Zygg> getListFour() {
        return zyggMapper.selectAllFour();
    }

    @Override
    public int save(Zygg zygg) {
        return zyggMapper.insertSelective(zygg);
    }

    @Override
    public int delete(String id) {
        return zyggMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Zygg zygg) {
        return zyggMapper.updateByPrimaryKeySelective(zygg);
    }

    @Override
    public Zygg getDetail(String id) {
        return zyggMapper.selectByPrimaryKey(id);
    }
}
