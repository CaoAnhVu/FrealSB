package com.example.frealsb.Services;

import com.example.frealsb.Entities.User;
import com.example.frealsb.Enums.EnumRole;
import com.example.frealsb.Repositories.RoleRepository;
import com.example.frealsb.Repositories.UserRepository;
import com.example.frealsb.RequestEntities.RequestRegisterUser;
import com.example.frealsb.RequestEntities.RequestUpdateUser;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // CURD
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> {
                    throw  new RuntimeException("Khong tim thay ID");
                }
        );
    }

    public User create(RequestRegisterUser req) {
        try{
            if(req.getPassword().equals(req.getConfirmPassword()) ) {
                final User user = req.toUser(roleRepository.findOneByName(EnumRole.USER));
                return userRepository.save(user);
            }else{
                throw new BadRequestException("Confirm password is not equals");
            }
        } catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    public User updateUser(RequestUpdateUser req) {
        try {
            User user = req.toUpdate(userRepository.findById(req.getId()).get());
            return userRepository.save(user);
        } catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    public User register(RequestRegisterUser req){
        try {
            if(req.getPassword().equals(req.getConfirmPassword()) ){
                req.setPassword(new BCryptPasswordEncoder().encode(req.getPassword()));
                User user = req.toUser(roleRepository.findOneByName(EnumRole.USER));
                return userRepository.save(user);
            }else{
                throw new BadRequestException("Confirm password is not equals");
            }
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
