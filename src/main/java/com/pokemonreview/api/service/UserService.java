package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.UserEntityDto;
import com.pokemonreview.api.dto.UserEntityResponseDto;

import java.util.List;

public interface UserService {

    List<UserEntityResponseDto> findAll();
    UserEntityResponseDto findById(int id);
    UserEntityResponseDto save(UserEntityDto theUser);

}
