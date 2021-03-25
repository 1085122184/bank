package com.example.bank.controller;

import com.example.bank.service.TbtjService;
import com.example.bank.service.YhkxService;
import com.example.bank.service.ZhxwService;
import com.example.bank.service.ZyggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    TbtjService tbtjService;
    @Autowired
    ZyggService zyggService;
    @Autowired
    YhkxService yhkxService;
    @Autowired
    ZhxwService zhxwService;


    @RequestMapping("/index")
    public String main(ModelMap modelMap){
        modelMap.put("tbtjList",tbtjService.getList());
        modelMap.put("zyggList",zyggService.getListFour());
        modelMap.put("yhkxList",yhkxService.getList());
        modelMap.put("zhxwList",zhxwService.getList());
        return "main";
    }
    @RequestMapping("/file")
    public String file(ModelMap modelMap){
        return "file";
    }
}
