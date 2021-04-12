package com.example.bank.service;


import com.example.bank.entity.Fj;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface FjService {
    List<Fj> getFjList(String ywkey);
    Map<String,Object> saveFj(MultipartFile file,String path,String ywkey);
    void downloadWj(Integer id, HttpServletResponse response) throws IOException;
}
