package ru.kata.springboot_securitydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springboot_securitydemo.model.User;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserServiceImp userServiceImp;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServiceImp.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }

        //return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),mapRolesToAuthority(user.getRoles()));
        //return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getAuthorities());
        return user;
    }
}
