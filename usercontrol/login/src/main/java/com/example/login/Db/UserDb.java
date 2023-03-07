package com.example.login.Db;

import java.util.ArrayList;
import java.util.List;

import com.example.login.Model.User;

public class UserDb {
    public static List<User> users = new ArrayList<>( List.of(
        new User(1,"a","a@gmail.com","111","aavar"),
        new User(2,"b","b@gmail.com","111","bavar"),
        new User(3,"c","c@gmail.com","111","cavar"),
        new User(4,"d","d@gmail.com","111","davar"),
        new User(5,"e","e@gmail.com","111","eavar")
    ));
}
