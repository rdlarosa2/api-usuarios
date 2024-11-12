package com.users.api.service;

import com.users.api.dto.UserEntityDto;
import com.users.api.dto.UserEntityResponseDto;
import com.users.api.models.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntityResponseDto> findAll();
    UserEntityResponseDto findById(int id);
    List<UserEntityResponseDto> findByName(String username);
    UserEntityResponseDto save(UserEntityDto theUser);

}
