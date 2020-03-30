package com.example.springwebcontent.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PasswordService {



    @Transactional
    public boolean passCheck(String password,String vpassword){
        if(password.equals("")) return false;
        if(!password.equals(vpassword)) return false;
        return true;
    }

}
