package com.example.bank.service;

import com.example.bank.entity.Zygg;

import java.util.List;

public interface ZyggService {
    List<Zygg> getList();
    List<Zygg> getListFour();
    int save(Zygg zygg);
    int delete(String id);
    int update(Zygg zygg);
}
