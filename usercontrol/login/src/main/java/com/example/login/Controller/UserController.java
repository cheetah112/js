package com.example.login.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.Model.UserDto;
import com.example.login.Request.UserRequest;
import com.example.login.Service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public UserDto login(@RequestBody UserRequest request){
        return userService.login(request);
    }
}
