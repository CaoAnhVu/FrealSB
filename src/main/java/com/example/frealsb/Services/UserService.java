package com.example.frealsb.Services;

import com.example.frealsb.Const.Constants;
import com.example.frealsb.Entities.User;
import com.example.frealsb.Enums.EnumRole;
import com.example.frealsb.Repositories.RoleRepository;
import com.example.frealsb.Repositories.UserRepository;
import com.example.frealsb.RequestEntities.RequestRegisterUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.frealsb.Services.Interface.IUserService;
import com.example.frealsb.Util.EncryptionUtils;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.ServletContext;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    private ServletContext servletContext;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean emailExists(String email) {
        return findByEmail(email) != null;
    }

    @Override
    public User register(RequestRegisterUser req) {
        try{
            if(req.getPassword().equals(req.getConfirmPassword()) ) {
                final User user = req.toUser(roleRepository.findOneByName(EnumRole.CUSTOMER));
                return userRepository.saveAndFlush(user);
            }else{
                throw new BadRequestException("Confirm password is not equals");
            }
        } catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void changeEmail(String newEmail, String currentPassword) throws AuthException {
        User user = currentUser();
        if (!new BCryptPasswordEncoder().matches(currentPassword, user.getPassword()))
            throw new AuthException("password does not match");

        user.setEmail(newEmail);

        userRepository.saveAndFlush(user);
    }

    @Override
    public void changePassword(String newPassword, String currentPassword) throws AuthException {
        User user = currentUser();

        if (!EncryptionUtils.PasswordMatch(currentPassword, user))
            throw new AuthException("password does not match");

        user.setPassword(EncryptionUtils.PasswordEncoder(newPassword));
        // Sử dụng saveAndFlush khi bạn cần đảm bảo dữ liệu được ghi vào cơ sở dữ liệu ngay lập tức
        userRepository.saveAndFlush(user);
    }

    @Override
    public void changeProfileInfo(User newProfileInfo) {
        User user = currentUser();

        user.setBio(newProfileInfo.getBio());

        userRepository.saveAndFlush(user);
    }

    @Override
    public void removeAvatar() {
        User user = currentUser();

        user.setAvatarPublicId(Constants.DEFAULT_AVATAR);

        userRepository.saveAndFlush(user);
    }

    @Override
    public void authenticate(User user) {
        UserDetails userDetails = loadUserByUsername(user.getEmail());

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Override
    public boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return auth != null && !(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated();
    }

    @Override
    public boolean isAdmin() {
        User user = currentUser();

        return user != null && user.hasRole(EnumRole.ADMIN);
    }

    @Override
    public User currentUser() {
        if(!isAuthenticated()){
            return null;
        }
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return userRepository.findByEmail(auth.getName());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
