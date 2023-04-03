package com.suhacan.graphqldemo.service;

import com.suhacan.graphqldemo.exception.UserNotFoundException;
import com.suhacan.graphqldemo.model.User;
import com.suhacan.graphqldemo.model.request.UserRequest;
import com.suhacan.graphqldemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public User createUser(UserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .mail(request.getMail())
                .role(request.getRole())
                .build();
        return userRepository.save(user);
    }

    public User updateUser(UserRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(request.getUsername());
        user.setMail(request.getMail());
        user.setRole(request.getRole());
        return userRepository.save(user);
    }

    public Boolean deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
        return true;
    }
}
