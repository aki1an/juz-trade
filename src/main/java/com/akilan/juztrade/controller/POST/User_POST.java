package com.akilan.juztrade.controller.POST;

import com.akilan.juztrade.entity.Users;
import com.akilan.juztrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class User_POST {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Object createUser(@RequestBody Users user){
        userService.createUser(user);
        return "created user";
    }

    @PutMapping("/forgotPassword")
    public Object changePassword(@RequestParam("userId")String userId,
                                 @RequestParam("passPhrase")String passPhase,
                                 @RequestParam("new_password")String newPassword){
        Users user = userService.getUser(userId);
        if(!user.getPassPhrase().equals(passPhase))
            return ResponseEntity.badRequest().body("pass phrase doesn't match can't validate the user");
        user.setPassword(newPassword);
        userService.createUser(user);
        return ResponseEntity.ok().body("password changed login with your new password");
    }

    @PutMapping("/update/profile")
    public ResponseEntity updateProfile(@RequestParam("userId")String userId,
                                        @RequestParam("password")String password,
                                        @RequestBody Users user){

        if (!userService.isValidUser(userId, password))
            return ResponseEntity.badRequest().body("no such users");

        userService.createUser(user);
     return ResponseEntity.ok().body(user);
    }
}
