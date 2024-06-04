package com.example.frealsb.RequestEntities;

import com.example.frealsb.Const.Constants;
import com.example.frealsb.Entities.Role;
import com.example.frealsb.Entities.User;
import com.example.frealsb.Enums.EnumRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestRegisterUser {
    private String firstName;

    private String lastName;

    @Email()
    private String email;

    @Size.List({
            @Size(min = 8, message = "Password too short"),
            @Size(max = 80, message = "Password too long")
    })
    private String confirmPassword;

    @Size.List({
            @Size(min = 8, message = "Password too short"),
            @Size(max = 80, message = "Password too long")
    })
    private String password;

    public User toUser(Role role){
        User user = new User();
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAvatarPublicId(Constants.DEFAULT_AVATAR);
        user.setCreatedAt(new Date());
        user.setEnabled(true);
        user.setRole(role);
        return user;
    }
}
