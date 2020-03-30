package com.example.springwebcontent.controller;


import com.example.springwebcontent.DTO.LoginRequest;
import com.example.springwebcontent.DTO.RegistrationRequest;
import com.example.springwebcontent.exceptions.LoginAlreadyExists;
import com.example.springwebcontent.exceptions.UserNotFoundException;
import com.example.springwebcontent.repository.entity.User;
import com.example.springwebcontent.service.PasswordService;
import com.example.springwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;

    @PostMapping(value = "/registration", produces = "text/html")
    @ResponseBody
    public String register(@RequestBody RegistrationRequest request) {
        String login = request.getLogin();
        String password = request.getPassword();
        String vpassword = request.getVpassword();
        if (!passwordService.passCheck(password, vpassword)) return "Пароли не совпадают!";
        try {
            return userService.adduser(login, password);
        } catch (LoginAlreadyExists ex) {
            return "Пользователь с таким логином существует";
        }
    }

    @PostMapping("/mainData")
    @ResponseBody
    public String getMainPageData(HttpServletRequest httpRequest) {
        Object objUser = httpRequest.getSession().getAttribute("User");
        if(objUser instanceof User) {
            User user = (User) objUser;
            return user.getLogin();
        }
        throw new UserNotFoundException();
    }


    @PostMapping(value = "/login", produces = "text/html")
    @ResponseBody
    public String login(@RequestBody LoginRequest request, HttpServletRequest httpRequest) {
        User user = userService.login(request.getLogin(), request.getPassword());
        if (user != null) {
            httpRequest.getSession().setAttribute("User", user);
            return "OK";
        }
        return "No";
    }
}