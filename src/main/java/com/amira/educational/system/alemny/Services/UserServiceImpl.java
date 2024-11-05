package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.CreateUserDTO;
import com.amira.educational.system.alemny.Dtos.UpdateUserDTO;
import com.amira.educational.system.alemny.Entities.User;
import com.amira.educational.system.alemny.Exceptions.NotFoundException;
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
        return UserRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

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
    public User updateUser(Long userId, UpdateUserDTO updateUserDTO) {
        // Retrieve the existing user by ID
        User existingUser = UserRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));

        if (updateUserDTO.getFirstName() != null)
            existingUser.setFirstName(updateUserDTO.getFirstName());
        if (updateUserDTO.getLastName() != null)
            existingUser.setLastName(updateUserDTO.getLastName());
        if (updateUserDTO.getEmail() != null)
            existingUser.setEmail(updateUserDTO.getEmail());
        if (updateUserDTO.getPhone() != null)
            existingUser.setPhone(updateUserDTO.getPhone());
        if (updateUserDTO.getCourse() != null)
            existingUser.setCourse(updateUserDTO.getCourse());

        // Save and return updated user
        return UserRepository.save(existingUser);
    }



    @Override
    public void deleteUser(Long id) {

        UserRepository.deleteById(id);
    }
}
