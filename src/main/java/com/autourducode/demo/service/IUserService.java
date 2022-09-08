package com.autourducode.demo.service;

import com.autourducode.demo.entity.Role;
import com.autourducode.demo.entity.User;
import com.autourducode.demo.model.UserForm;

public interface IUserService {

    User create(UserForm userForm);

    Iterable<User> gets();

    User update(Long id, User user);

    String delete(Long id);

    User get(Long id);

    User getByEmail(String email);

    User check_password(String email, String password);

    void createRole(Role role);

    void addRoleToUser(String email, String roleName);
}
