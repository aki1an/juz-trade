package com.akilan.juztrade.service;


import com.akilan.juztrade.entity.Users;
import com.akilan.juztrade.repositery.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UsersRepo usersRepo;

    @Override
    public boolean createUser(Users user) {
        usersRepo.save(user);
        return false;
    }

    @Override
    public Object getUsers() {
        return usersRepo.findAll();
    }

    @Override
    public boolean isValidUser(String userId, String password) {
        String truePass = usersRepo.fetchPasswordByUserId(userId);
        return password.equals(truePass);
    }
    @Override
    public Users getUser(String userId) {
        Users resultUser = usersRepo.findById(userId).get();
        return resultUser;
    }
}
