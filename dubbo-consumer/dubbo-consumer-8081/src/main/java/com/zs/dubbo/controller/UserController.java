package com.zs.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zs.dubbo.model.User;
import com.zs.dubbo.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * @Company
 * @Author Zs
 * @Date Create in 2019/9/7
 **/
@Controller
@SessionAttributes("user")
public class UserController {

    @Reference(loadbalance = "roundrobin")
    private IUserService userService;

    @RequestMapping("/")
    public String turnLoginPage() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        Map<String, Object> resultMap = userService.selectByUsernameAndPassword(username, password);
        if (200 == (Integer) resultMap.get("code")) {
            User user = (User) resultMap.get("result");
            model.addAttribute("user", user);
            return "redirect:/index";
        }
        return "404";
    }

}
