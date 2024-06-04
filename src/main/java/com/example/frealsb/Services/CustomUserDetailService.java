package com.example.frealsb.Services;

import com.example.frealsb.Entities.User;
import com.example.frealsb.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        List<GrantedAuthority> listAuth = new ArrayList<>();
        for (String role: BuildRolesFromRole(String.valueOf(user.getRole().getRoleName()))){
            listAuth.add(new SimpleGrantedAuthority(role));
        }
        UserDetails userDetails =  org.springframework.security.core.userdetails.User.builder().username(user.getEmail()).password(user.getPassword()).authorities(listAuth).build();
        return userDetails;
    }
    public List<String> BuildRolesFromRole(String role){
        String roles = "ADMIN,MODIFIER,USER";
        int index = role.indexOf(role);
        return Arrays.stream(roles.substring(index).split(",")).toList();
    }
}