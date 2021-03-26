package com.example.bank.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Admincontroller {

    @RequestMapping("admin")
    public String admin(){

        return "index";
    }

    @RequestMapping("xxlr")
    public String add(String type, ModelMap modelMap){
        modelMap.put("ywkey", StrUtil.uuid());
        modelMap.put("type",type);
        return "add";
    }



}
