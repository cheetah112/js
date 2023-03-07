package com.example.login.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.Model.User;
import com.example.login.Model.UserDto;
import com.example.login.Repository.UserRespository;
import com.example.login.Request.UserRequest;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;

    public UserDto login(UserRequest request) {
        return userRespository.login(request);
    }
    
}
