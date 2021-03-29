package com.example.bank.service;

import com.example.bank.entity.Yhkx;

import java.util.List;

public interface YhkxService {
    List<Yhkx> getList();
    int save(Yhkx yhkx);
    int delete(String id);
    int update(Yhkx yhkx);
}
