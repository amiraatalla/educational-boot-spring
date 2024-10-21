package com.amira.educational.system.alemny.Services;

import com.amira.educational.system.alemny.Dtos.UserDTO;
import com.amira.educational.system.alemny.Entities.User;
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
    public User saveUser(UserDTO userDTO) {
        // تحويل DTO إلى كيان (Entity)
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setCourse(userDTO.getCourse());

        // حفظ الكيان في قاعدة البيانات
        return UserRepository.save(user);
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setCourse(userDTO.getCourse());
        return UserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }
}
