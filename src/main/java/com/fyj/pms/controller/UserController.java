package com.fyj.pms.controller;

import com.alibaba.fastjson.JSONObject;
import com.fyj.pms.entity.User;
import com.fyj.pms.service.UserService;
import com.t2w.utils.captcha.VaptchaUtils;
import com.t2w.utils.captcha.configuration.Vaptcha;
import com.t2w.utils.captcha.domain.CaptchaStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public JSONObject login(User user) {
        JSONObject data = new JSONObject();
        log.info("信息日志");
        log.warn("警告日志");
        log.error("错误日志");
        if (user != null) {
            user = userService.findUser(user);
        }
        if (user != null) {
            data.put("status", "success");
        } else {
            data.put("status", "fail");
        }
        return data;
    }

}
