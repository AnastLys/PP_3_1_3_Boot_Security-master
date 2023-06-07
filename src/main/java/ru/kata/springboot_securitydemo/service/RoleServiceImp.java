package ru.kata.springboot_securitydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.springboot_securitydemo.model.Role;
import ru.kata.springboot_securitydemo.repositories.RoleRepository;

import java.util.List;
@Service
public class RoleServiceImp implements RoleService{
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }
}
