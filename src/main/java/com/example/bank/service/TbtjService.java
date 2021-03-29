package com.example.bank.service;

import com.example.bank.entity.Tbtj;

import java.util.List;

public interface TbtjService {
    List<Tbtj> getList();
    int save(Tbtj tbtj);
    int delete(String id);
    int update(Tbtj tbtj);
}
