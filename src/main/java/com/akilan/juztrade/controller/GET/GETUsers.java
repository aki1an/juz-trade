package com.akilan.juztrade.controller.GET;

import com.akilan.juztrade.repositery.UsersRepo;
import com.akilan.juztrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GETUsers {

    private final UserService userService;

    public GETUsers(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello(){
        return "<h1><i>the index of juz-trade api</i><h1>";
    }

    @GetMapping("/user/{userId}")
    public static Object getUserById(@PathVariable("userId") String userId) {
        return new String("userId : " + userId);
    }

    @GetMapping("/users")
    public Object getUsers() {
        return userService.getUsers();
    }

}
