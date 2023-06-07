package ru.kata.springboot_securitydemo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.springboot_securitydemo.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
