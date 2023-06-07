package ru.kata.springboot_securitydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.springboot_securitydemo.model.User;
import ru.kata.springboot_securitydemo.repositories.UserRepository;

import java.util.List;


@Service
public class UserServiceImp implements  UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }


    @Transactional
    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    @Transactional
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
    @Transactional
    @Override
    public User findUser(long id) throws UsernameNotFoundException{
        return userRepository.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void deleteUser(long id) {
            userRepository.deleteById(id);
    }
    @Transactional
    @Override
    public void updeteUser(User user) {
        if (userRepository.existsById(user.getId())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setPassword(user.getPassword());
            userRepository.save(user);
        }
    }


}
