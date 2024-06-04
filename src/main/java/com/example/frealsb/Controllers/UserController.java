package com.example.frealsb.Controllers;

import com.example.frealsb.Entities.User;
import com.example.frealsb.RequestEntities.RequestRegisterUser;
import com.example.frealsb.Services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    User Register(@RequestBody @Valid RequestRegisterUser registerUser){
        return userService.register(registerUser);
    }
}
