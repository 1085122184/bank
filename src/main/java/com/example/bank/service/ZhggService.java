package com.example.bank.service;

import com.example.bank.entity.Zhgg;

import java.util.List;

public interface ZhggService {
    List<Zhgg> getList();
    int save(Zhgg zhgg);
    int delete(String id);
    int update(Zhgg zhgg);
}
