package com.naitik.healthcaremonitoringsystem.service;

import com.naitik.healthcaremonitoringsystem.dto.UserDTO;
import com.naitik.healthcaremonitoringsystem.entity.User;
import com.naitik.healthcaremonitoringsystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());

        // Password Encrypt
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        user.setRole(userDTO.getRole());

        userRepository.save(user);

        return userDTO;
    }
}