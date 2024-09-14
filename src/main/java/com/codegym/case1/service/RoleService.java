package com.codegym.case1.service;


import com.codegym.case1.model.Role;


public interface RoleService {
    Iterable<Role> findAll();

    void save(Role role);

    Role findByName(String name);
}
