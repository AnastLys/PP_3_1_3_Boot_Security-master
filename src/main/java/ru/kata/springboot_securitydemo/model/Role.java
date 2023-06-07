package ru.kata.springboot_securitydemo.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

/*    @Transient
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;*/

    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public Collection<User> getUsers() {
        return users;
    }*/

/*    public void setUsers(Set<User> users) {
        this.users = users;
    }*/

    @Override
    public String getAuthority() {
        return getName();
    }


}
