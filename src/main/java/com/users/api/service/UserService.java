package com.users.api.service;

import com.users.api.dto.UserEntityDto;
import com.users.api.dto.UserEntityResponseDto;

import java.util.List;

public interface UserService {

    List<UserEntityResponseDto> findAll();
    UserEntityResponseDto findById(int id);
    UserEntityResponseDto save(UserEntityDto theUser);

}
