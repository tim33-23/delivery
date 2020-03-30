package com.example.springwebcontent.repository.entity;


import javax.persistence.*;


@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;


    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}
}
