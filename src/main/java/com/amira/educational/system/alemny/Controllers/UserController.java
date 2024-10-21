package com.amira.educational.system.alemny.Controllers;

import com.amira.educational.system.alemny.Dtos.UserDTO;
import com.amira.educational.system.alemny.Entities.User;
import com.amira.educational.system.alemny.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService UserService;

    // Constructor-based Dependency Injection
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping("/get-all")
    public List<User> getAllUsers() {
        return UserService.getAllUsers();
    }

    @GetMapping("/get-by-id/{id}")
    public User getUserById(@PathVariable Long id) {
        return UserService.getUserById(id);
    }

    @PostMapping("/add-user")
    public User addUser(@RequestBody UserDTO UserDTO) {
        return UserService.saveUser(UserDTO);
    }

    @PatchMapping("/update-user/{id}")
    public User updateUser(@RequestBody UserDTO UserDTO) {
        return UserService.updateUser(UserDTO);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        UserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
