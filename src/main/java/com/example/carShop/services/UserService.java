package com.example.carShop.services;

import com.example.carShop.dto.users.UserDTO;
import com.example.carShop.exceptions.CarApiException;
import com.example.carShop.mappers.UserMapper;
import com.example.carShop.models.User;
import com.example.carShop.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void saveUser(UserDTO userDTO) {
        User user = userMapper.mapToEntity(userDTO);
        userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long userId) throws CarApiException {
        return userRepository.findById(userId).orElseThrow(() -> new CarApiException("User not found", HttpStatus.NOT_FOUND));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
