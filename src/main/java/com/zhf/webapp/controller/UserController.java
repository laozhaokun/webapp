package com.zhf.webapp.controller;

import com.zhf.webapp.model.User;
import com.zhf.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhaohf on 2015/4/5.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="/users",method = RequestMethod.GET)
    public String listUsers(Model model,Integer offset, Integer maxResults){
        model.addAttribute("users",this.userService.listUsers(offset,maxResults));
        model.addAttribute("count",this.userService.count());
        model.addAttribute("offset",offset);
        return "/user/user-list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new User());
        return "/user/user-add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@Validated User user,BindingResult result){
        if(result.hasErrors())
            return "/user/user-add";
        if(user.getId() == 0)
            this.userService.add(user);
        else
            this.userService.update(user);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id){
        this.userService.delete(id);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model){
        model.addAttribute(this.userService.getUserById(id));
        return "/user/user-update";
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String update(@Validated User user, BindingResult result,@PathVariable int id){
        if(result.hasErrors()){
            return "/user/user-update";
        }
        this.userService.update(user);
        return "redirect:/user/users";
    }
}
