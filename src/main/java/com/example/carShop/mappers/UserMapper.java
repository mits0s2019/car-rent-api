package com.example.carShop.mappers;

import com.example.carShop.dto.users.SaveUserDTO;
import com.example.carShop.dto.users.UserDTO;
import com.example.carShop.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    User mapToEntity(SaveUserDTO saveUserDTO);

    List<UserDTO> mapToListDTO(List<User> cars);
}
