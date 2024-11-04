package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateUserDTO;
import com.amira.educational.system.alemny.Entities.User;
import com.amira.educational.system.alemny.Exceptions.UserNotFoundException;
import com.amira.educational.system.alemny.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository UserRepository;

    // Constructor-based Dependency Injection
    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public List<User> getAllUsers() {

        return UserRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {

        return UserRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(CreateUserDTO createUserDTO) {

        User user = User.builder()
                .firstName(createUserDTO.getFirstName())
                .lastName(createUserDTO.getLastName())
                .email(createUserDTO.getEmail())
                .phone(createUserDTO.getPhone())
                .course(createUserDTO.getCourse())
                .build();

        return UserRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, CreateUserDTO createUserDTO) {
        // Retrieve the existing user by ID
        User existingUser = UserRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        if (createUserDTO.getFirstName() != null) existingUser.setFirstName(createUserDTO.getFirstName());
        if (createUserDTO.getLastName() != null) existingUser.setLastName(createUserDTO.getLastName());
        if (createUserDTO.getEmail() != null) existingUser.setEmail(createUserDTO.getEmail());
        if (createUserDTO.getPhone() != null) existingUser.setPhone(createUserDTO.getPhone());
        if (createUserDTO.getCourse() != null) existingUser.setCourse(createUserDTO.getCourse());

        // Save and return updated user
        return UserRepository.save(existingUser);
    }


    @Override
    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }
}
