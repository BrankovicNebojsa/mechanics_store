package com.mechanics_store.controller.mapper;

import com.mechanics_store.controller.dto.UserDTO;
import com.mechanics_store.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDTO> {

    @Override
    public UserDTO entityToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getUsername()
        );
    }

    @Override
    public User DTOToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return new User();
        }
        return User.builder()
                .id(userDTO.id())
                .firstName(userDTO.firstName())
                .lastName(userDTO.lastName())
                .username(userDTO.username())
                .email(userDTO.email())
                .phoneNumber(userDTO.phoneNumber())
                .build();
    }
}
