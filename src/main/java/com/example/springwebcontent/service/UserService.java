package com.example.springwebcontent.service;


import com.example.springwebcontent.exceptions.LoginAlreadyExists;
import com.example.springwebcontent.repository.UserRepository;
import com.example.springwebcontent.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordService passwordService;
    @Autowired
    private UserService self;



    public String adduser(String name, String password) throws LoginAlreadyExists {
        try {
            User user = new User();
            user.setLogin(name);
            user.setPassword(password);
            repository.save(user);
            return "OK";
        } catch (DataIntegrityViolationException ex) {
            throw new LoginAlreadyExists();
        }
    }

    public User getUserByLogin(String login) {
        return repository.findByLogin(login);
    }


    public User login(String login, String password) {
        User existingUser = getUserByLogin(login);
        if(existingUser == null) {
            return null;
        }
        String vpassword = existingUser.getPassword();
        if (!passwordService.passCheck(password, vpassword)){
            return null;
        }
        return existingUser;
    }
}
