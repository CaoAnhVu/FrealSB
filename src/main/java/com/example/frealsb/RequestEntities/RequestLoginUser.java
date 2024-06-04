package com.example.frealsb.RequestEntities;

import com.example.frealsb.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestLoginUser {
    private String password;
    private String email;

    public User toUser(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}