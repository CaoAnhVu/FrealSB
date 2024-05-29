package com.example.frealsb.Services;

import com.example.frealsb.Entities.User;
import com.example.frealsb.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
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

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
    // -------------------------------------------

    public void login(String username, String password) {}

    public void logout() {}

    public void resetPassword(String id, String password) {}

    public void changePassword(String id, String oldPassword, String newPassword) {}

    public void changeAvatar(String id, String avatar) {}

    public void getEvent(){}

    public void getFood(){}

    public void getPost(){}

    public void getCurrentUser(){}

    public void getLocation(){}
}
