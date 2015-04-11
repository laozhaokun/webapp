package com.zhf.webapp.controller;

import com.zhf.webapp.model.Host;
import com.zhf.webapp.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhaohf on 2015/4/6.
 */
@Controller
@RequestMapping(value = "host")
public class HostController {

    @Autowired
    private HostService hostService;

    @RequestMapping(value = "/hosts",method = RequestMethod.GET)
    public String listHosts(Model model,Integer offset, Integer maxResults){
        model.addAttribute("hosts",this.hostService.listHosts(offset,maxResults));
        model.addAttribute("count",this.hostService.count());
        model.addAttribute("offset",offset);
        return "/host/host-list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new Host());
        return "/host/host-add";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@Validated Host host,BindingResult result){
          if(result.hasErrors())
              return "/host/host-add";
          host.setFlag("added");
          this.hostService.add(host);
        return "redirect:/host/hosts";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable int id,Model model){
        model.addAttribute(this.hostService.getHostById(id));
        return "/host/host-update";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String update(@Validated Host host,BindingResult result,@PathVariable int id){
        if(result.hasErrors())
            return "host/host-update";
        this.hostService.update(host);
        return "redirect:/host/hosts";
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        this.hostService.delete(id);
        return "redirect:/host/hosts";
    }
    @RequestMapping(value = "/delete_real/{id}",method = RequestMethod.GET)
    public String delete_real(@PathVariable int id){
        this.hostService.delete_real(id);
        return "redirect:/host/hosts";
    }
}
