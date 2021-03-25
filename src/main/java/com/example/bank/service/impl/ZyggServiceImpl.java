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
}
