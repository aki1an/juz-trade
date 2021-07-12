package com.akilan.juztrade.service;

import com.akilan.juztrade.entity.Users;

public interface UserService {

    public boolean createUser(Users user);
    Object getUsers();
    public boolean isValidUser(String userId,String password);
    Users getUser(String userId);

}
