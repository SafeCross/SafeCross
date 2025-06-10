package com.safeCrossApi.service;

import com.safeCrossApi.dto.UserRequestDTO;
import com.safeCrossApi.dto.UserResponseDTO;
import com.safeCrossApi.dto.LoginRequestDTO;

public interface UserService {
    UserResponseDTO registerUser(UserRequestDTO requestDTO);
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
    UserResponseDTO getById(Long id);
    UserResponseDTO updateUser(Long id, UserRequestDTO updateDTO);
}