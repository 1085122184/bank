package com.example.bank.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.ftp.Ftp;
import com.example.bank.dao.FjMapper;
import com.example.bank.entity.Fj;
import com.example.bank.service.FjService;
import com.example.bank.utils.MultipartFileToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FjServiceImpl implements FjService {
    @Autowired
    FjMapper fjMapper;

    @Override
    public List<Fj> getFjList(String ywkey) {
        return fjMapper.selectByYwKey(ywkey);
    }

    @Override
    public Map<String, Object> saveFj(MultipartFile multipartFile,String path,String ywkey) {
        Map<String,Object> map = new HashMap<>();
        try(Ftp ftp = new Ftp("59.110.113.232",21,"user","user")) {
            File file = MultipartFileToFile.multipartFileToFile(multipartFile);
            String[] split = multipartFile.getOriginalFilename().split("\\.");
            String kzm = ((split != null && split.length > 0) ? split[split.length - 1]
                    : "unknow");// 扩展名
            ftp.upload(path,StrUtil.uuid()+"."+kzm,file);
            Fj fj = new Fj();
            fj.setCcmc(StrUtil.uuid()+"."+kzm);
            fj.setFilename(multipartFile.getOriginalFilename());
            fj.setWjdx(multipartFile.getBytes().length);
            fj.setXdpath(path);
            fj.setYwkey(ywkey);
            fjMapper.insert(fj);
            map.put("success",true);
            map.put("msg","文件上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","文件上传失败！");
        }


        return map;
    }
}
