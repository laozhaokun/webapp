package com.zhf.webapp.controller;

import com.zhf.webapp.model.Phone;
import com.zhf.webapp.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/22.
 */
@Controller
public class PhoneController{
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "phone",method = RequestMethod.GET)
    public String phone(){
        return "chart/phone";
    }

    @RequestMapping(value = "api5",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Phone> listPhones(@RequestParam int day){
        return this.phoneService.listPhones(day);
    }
}
