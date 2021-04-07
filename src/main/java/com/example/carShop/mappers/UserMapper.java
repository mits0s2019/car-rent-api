package com.example.carShop.mappers;

import com.example.carShop.dto.users.UserDTO;
import com.example.carShop.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    User mapToEntity(UserDTO saveUserDTO);

    List<UserDTO> mapToListDTO(List<User> cars);

//    Page<UserDTO> mapToPageDTO(Page<User> user);
}
