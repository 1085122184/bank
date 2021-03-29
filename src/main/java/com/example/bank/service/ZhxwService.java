package com.example.bank.service;

import com.example.bank.entity.Zhxw;

import java.util.List;

public interface ZhxwService {
    List<Zhxw> getList();
    int save(Zhxw zhxw);
    int delete(String id);
    int update(Zhxw zhxw);
}
