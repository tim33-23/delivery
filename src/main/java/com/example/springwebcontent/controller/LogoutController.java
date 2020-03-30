package com.example.springwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

    @PostMapping("/logout")
    @ResponseBody
    public void logout(HttpServletRequest request){
        request.getSession().invalidate();
    }

}
