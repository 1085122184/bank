package com.example.bank.controller;

import com.example.bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    @Autowired
    ZhggService zhggService;
    @Autowired
    FjService fjService;

    @RequestMapping("/index")
    public String main(ModelMap modelMap){
        modelMap.put("tbtjList",tbtjService.getList());
        modelMap.put("zyggList",zyggService.getListFour());
        modelMap.put("yhkxList",yhkxService.getList());
        modelMap.put("zhxwList",zhxwService.getList());
        modelMap.put("zhggList",zhggService.getList());
        return "main";
    }

    @RequestMapping("/index/title")
    public String title(ModelMap modelMap,String id,String type){
        switch (type){
            case "zhxw":
                modelMap.put("object",zhxwService.getDetail(id));
                break;
            case "zygg":
                modelMap.put("object",zyggService.getDetail(id));
                break;
            case "zhgg":
                modelMap.put("object",zhggService.getDetail(id));
                modelMap.put("fjList",fjService.getFjList(id));
                break;
            case "yhkx":
                modelMap.put("object",yhkxService.getDetail(id));
                modelMap.put("fjList",fjService.getFjList(id));
                break;
        }
        modelMap.put("type",type);
        return "zhxw";
    }


    @RequestMapping("/index/getFj")
    public void file(Integer id, HttpServletResponse response) throws IOException {
        fjService.downloadWj(id,response);
    }
}
