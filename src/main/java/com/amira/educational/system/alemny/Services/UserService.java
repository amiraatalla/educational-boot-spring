package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.UserDTO;
import com.amira.educational.system.alemny.Entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(UserDTO userDTO);
    User updateUser(UserDTO userDTO);
    void deleteUser(Long id);
}
