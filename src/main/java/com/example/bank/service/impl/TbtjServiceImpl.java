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

    @Override
    public int save(Tbtj tbtj) {
        return tbtjMapper.insertSelective(tbtj);
    }

    @Override
    public int delete(String id) {
        return tbtjMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Tbtj tbtj) {
        return tbtjMapper.updateByPrimaryKeySelective(tbtj);
    }

    @Override
    public Tbtj getDetail(String id) {
        return tbtjMapper.selectByPrimaryKey(id);
    }
}
