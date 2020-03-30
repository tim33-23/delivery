package com.example.springwebcontent.controller;

import com.example.springwebcontent.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class WebExceptionHandler  {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public void userNotFound(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        response.setHeader("cause", "usernotfound");
        response.setStatus(400);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String otherExceptions(Exception ex) {
        System.out.println("Что-то пошло не так:" + ex.toString());
        return "АААА! У нас Ошибка!";
    }
}
