package com.zhf.webapp.controller;

import com.zhf.webapp.model.UrlRefKwCount;
import com.zhf.webapp.service.UrlRefKwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/20.
 */
@Controller
public class UrlRefKwController {

    private UrlRefKwService urlRefKwService;

    @Autowired
    public UrlRefKwController(UrlRefKwService urlRefKwService) {
        this.urlRefKwService = urlRefKwService;
    }

    @RequestMapping(value = "/api3", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<UrlRefKwCount> getRefKw(@RequestParam(value = "url") String url) {
        return this.urlRefKwService.getRefKw(url);
    }

    @RequestMapping(value = "/api4", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<UrlRefKwCount> getRefEngine(@RequestParam(value = "url") String url) {
        return this.urlRefKwService.getRefEngine(url);
    }
}
