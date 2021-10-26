package com.yjxxt.crm.controller;

import com.yjxxt.crm.base.BaseController;
import com.yjxxt.crm.bean.User;
import com.yjxxt.crm.service.UserService;
import com.yjxxt.crm.utils.LoginUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends BaseController {


    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("main")
    public String main(HttpServletRequest req){
        //获取当前用户信息
        int userId = LoginUserUtil.releaseUserIdFromCookie(req);
        //根据id查信息
        User user = userService.selectByPrimaryKey(userId);
        //存储
        req.setAttribute("user",user);
        return "main";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
