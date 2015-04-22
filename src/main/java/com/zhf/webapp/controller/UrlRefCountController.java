package com.zhf.webapp.controller;

import com.zhf.webapp.model.UrlRefCount;
import com.zhf.webapp.service.UrlRefCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/11.
 */
@Controller
//@RequestMapping("api")
public class UrlRefCountController {

    private UrlRefCountService urlRefCountService;
    @Autowired
    public UrlRefCountController(UrlRefCountService urlRefCountService) {
        this.urlRefCountService = urlRefCountService;
    }
    @RequestMapping(value = "/api",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<UrlRefCount> getURCInJson(@RequestParam(value = "url") String url){
        List<UrlRefCount> lists = urlRefCountService.getURC(url);
        return lists;
    }

    @RequestMapping(value = "/api2",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<UrlRefCount> getURC2InJson(@RequestParam(value = "ref") String ref){
        List<UrlRefCount> lists = urlRefCountService.getURC2(ref);
        return lists;
    }

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String search(){
        return "/chart/search";
    }
}
