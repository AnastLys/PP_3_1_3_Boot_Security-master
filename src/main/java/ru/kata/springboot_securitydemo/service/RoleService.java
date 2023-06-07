package ru.kata.springboot_securitydemo.service;


import ru.kata.springboot_securitydemo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
}
