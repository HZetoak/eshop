package com.example.eshop.login.entity;

import lombok.Data;

import java.util.Set;

@Data
public class User {
    private String id;
    private String userName;
    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
    //省略set、get方法等.....
}
