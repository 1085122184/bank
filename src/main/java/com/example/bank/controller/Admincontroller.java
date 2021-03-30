package com.example.bank.controller;

import cn.hutool.core.util.StrUtil;
import com.example.bank.entity.*;
import com.example.bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class Admincontroller {
    @Autowired
    TbtjService tbtjService;
    @Autowired
    YhkxService yhkxService;
    @Autowired
    ZyggService zyggService;
    @Autowired
    ZhggService zhggService;
    @Autowired
    ZhxwService zhxwService;

    @RequestMapping("adminLogin")
    public String adminLogin(){
        return "logins";
    }

    @RequestMapping("admin")
    public String admin(){
        return "index";
    }

    @RequestMapping("xxlr")
    public String add(String type, ModelMap modelMap){
        modelMap.put("ywkey", StrUtil.uuid());
        modelMap.put("type",type);
        modelMap.put("sign","add");
        return "add";
    }

    @RequestMapping("getList")
    public String getList(String type,ModelMap map){
        switch (type){
            case "tbtj":
                map.put("type",type);
                map.put("list",tbtjService.getList());
                break;
            case "yhkx":
                map.put("type",type);
                map.put("list",yhkxService.getList());
                break;
            case "zygg":
                map.put("type",type);
                map.put("list",zyggService.getList());
                break;
            case "zhgg":
                map.put("type",type);
                map.put("list",zhggService.getList());
                break;
            case "zhxw":
                map.put("type",type);
                map.put("list",zhxwService.getList());
                break;
        }
        return "list";
    }

    @RequestMapping("edit")
    public String edit(String id,String type,ModelMap map){
        map.put("sign","edit");
        switch (type){
            case "tbtj":
                map.put("type",type);
                map.put("object",tbtjService.getDetail(id));
                break;
            case "yhkx":
                map.put("type",type);
                map.put("object",yhkxService.getDetail(id));
                break;
            case "zygg":
                map.put("type",type);
                map.put("object",zyggService.getDetail(id));
                break;
            case "zhgg":
                map.put("type",type);
                map.put("object",zhggService.getDetail(id));
                break;
            case "zhxw":
                map.put("type",type);
                map.put("object",zhxwService.getDetail(id));
                break;
        }
        return "add";
    }

    @RequestMapping("tbtjAdd")
    @ResponseBody
    public int tbtjAdd(@RequestBody Tbtj tbtj){
        return tbtjService.save(tbtj);
    }
    @RequestMapping("tbtjEdit")
    @ResponseBody
    public int tbtjEdit(@RequestBody Tbtj tbtj){
        return tbtjService.update(tbtj);
    }
    @RequestMapping("tbtjDel")
    @ResponseBody
    public int tbtjDel(String id){
        return tbtjService.delete(id);
    }


    @RequestMapping("yhkxAdd")
    @ResponseBody
    public int yhkxAdd(@RequestBody Yhkx yhkx){
        return yhkxService.save(yhkx);
    }
    @RequestMapping("yhkxEdit")
    @ResponseBody
    public int yhkxEdit(@RequestBody Yhkx yhkx){
        return yhkxService.update(yhkx);
    }
    @RequestMapping("yhkxDel")
    @ResponseBody
    public int yhkxDel(String id){
        return yhkxService.delete(id);
    }


    @RequestMapping("zyggAdd")
    @ResponseBody
    public int zyggAdd(@RequestBody Zygg zygg){
        return zyggService.save(zygg);
    }
    @RequestMapping("zyggEdit")
    @ResponseBody
    public int zyggEdit(@RequestBody Zygg zygg){
        return zyggService.update(zygg);
    }
    @RequestMapping("zyggDel")
    @ResponseBody
    public int zyggDel(String id){
        return zyggService.delete(id);
    }


    @RequestMapping("zhggAdd")
    @ResponseBody
    public int zhggAdd(@RequestBody Zhgg zhgg){
        return zhggService.save(zhgg);
    }
    @RequestMapping("zhggEdit")
    @ResponseBody
    public int zhggEdit(@RequestBody Zhgg zhgg){
        return zhggService.update(zhgg);
    }
    @RequestMapping("zhggDel")
    @ResponseBody
    public int zhggDel(String id){
        return zhggService.delete(id);
    }


    @RequestMapping("zhxwAdd")
    @ResponseBody
    public int zhxwAdd(@RequestBody Zhxw zhxw){
        return zhxwService.save(zhxw);
    }
    @RequestMapping("zhxwEdit")
    @ResponseBody
    public int zhxwEdit(@RequestBody Zhxw zhxw){
        return zhxwService.update(zhxw);
    }
    @RequestMapping("zhxwDel")
    @ResponseBody
    public int zhxwDel(String id){
        return zhxwService.delete(id);
    }

}
