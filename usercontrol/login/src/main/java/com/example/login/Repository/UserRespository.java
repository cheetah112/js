package com.example.login.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.login.Db.UserDb;
import com.example.login.Exception.BadRequestException;
import com.example.login.Model.User;
import com.example.login.Model.UserDto;
import com.example.login.Request.UserRequest;

@Repository
public class UserRespository {

    public UserDto login(UserRequest request) {
        Optional<User> userOptional =  UserDb.users.stream().
        filter(user -> user.getUsername().equals(request.getUsername()) 
        && user.getPassword().equals(request.getPassword())).findFirst();

        if(userOptional.isPresent()){
            return new UserDto(userOptional.get().getUsername(), userOptional.get().getEmail(), userOptional.get().getAvatar());
        }else{
            throw new BadRequestException("username hoặc password chưa chính xác.");
        }
    }
    
}
