package com.example.carShop.services;

import com.example.carShop.dto.users.SaveUserDTO;
import com.example.carShop.exceptions.CarApiException;
import com.example.carShop.mappers.UserMapper;

import com.example.carShop.models.User;
import com.example.carShop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void saveUser(SaveUserDTO userDTO) {
        User user = userMapper.mapToEntity(userDTO);
        userRepository.save(user);
    }


    public User findUserById(Long userId) throws CarApiException {
        return userRepository.findById(userId).orElseThrow(() -> new CarApiException("User not found", HttpStatus.NOT_FOUND));
    }
}
