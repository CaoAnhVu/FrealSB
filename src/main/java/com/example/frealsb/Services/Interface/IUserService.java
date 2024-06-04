package com.example.frealsb.Services.Interface;

import com.example.frealsb.Entities.User;
import com.example.frealsb.RequestEntities.RequestRegisterUser;
import jakarta.security.auth.message.AuthException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    User findByEmail(String email);

    boolean emailExists(String email);

    User register(RequestRegisterUser req);

    void changeEmail(String newEmail, String currentPassword) throws AuthException;

    void changePassword(String newPassword, String currentPassword) throws AuthException;

    void changeProfileInfo(User newProfileInfo);

//    void changeAvatar(UploadedAvatarInfo uploadedAvatarInfo);

    void removeAvatar();

    void authenticate(User user);

    boolean isAuthenticated();

    boolean isAdmin();

    User currentUser();

}
