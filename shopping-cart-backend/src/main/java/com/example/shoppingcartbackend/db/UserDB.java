package com.example.shoppingcartbackend.db;

import com.example.shoppingcartbackend.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    public static List<User> users = new ArrayList<>(
            List.of(new User(1,"Nguyễn A", "a@gmail.com", "0911111111", "avaA"),
                    new User(2,"Nguyễn B", "b@gmail.com", "0911111112", "avaB"),
                    new User(3,"Nguyễn C", "c@gmail.com", "0911111113", "avaC"))
    );
}
