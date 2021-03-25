package com.example.bank.controller;

import com.example.bank.service.FjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("file")
public class FjController {
    @Autowired
    FjService fjService;

    @RequestMapping("uploadFile")
    public Map<String,Object> fileUpload(@RequestParam("uploadFile") MultipartFile uploadFile){
        Map<String,Object> map =  fjService.saveFj(uploadFile,"zhgg","1");
        return map;
    }
}
