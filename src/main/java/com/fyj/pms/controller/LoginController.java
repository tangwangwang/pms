package com.fyj.pms.controller;

import com.fyj.pms.entity.User;
import com.fyj.pms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @author T2W
 * @version V1.0.0
 * @email tang.wangwang@qq.com
 * @date 2019-08-22 14:45
 * @name com.fyj.pms.controller.LoginController.java
 * @see describing
 */
@Controller
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user) {
        log.info("信息日志");
        log.warn("警告日志");
        log.error("错误日志");
        if (user != null) {
            user = userService.findUser(user);
        }
        if (user != null) {
            return "redirect:/index";
        } else {
            return "login";
        }
    }

    @GetMapping("/index")
    public String index(HttpServletResponse response){
        return "index";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "common/welcome";
    }

}
