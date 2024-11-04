package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateUserDTO;

import com.amira.educational.system.alemny.Entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(CreateUserDTO createUserDTO);
    User updateUser(Long id, CreateUserDTO createUserDTO);
    void deleteUser(Long id);
}
