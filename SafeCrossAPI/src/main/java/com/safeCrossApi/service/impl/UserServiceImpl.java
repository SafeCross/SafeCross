package com.safeCrossApi.service.impl;

import com.safeCrossApi.dto.UserRequestDTO;
import com.safeCrossApi.dto.UserResponseDTO;
import com.safeCrossApi.dto.LoginRequestDTO;
import com.safeCrossApi.model.UserModel;
import com.safeCrossApi.repository.UserRepository;
import com.safeCrossApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao hashear a senha", e);
        }
    }

    @Override
    public UserResponseDTO registerUser(UserRequestDTO requestDTO){
        UserModel user = new UserModel();
        user.setName(requestDTO.getName());
        user.setEmail(requestDTO.getEmail());
        user.setPasswordHash(hashPassword(requestDTO.getPassword()));
        user.setRegistrationDate(LocalDateTime.now());
        user.setDeviceId(requestDTO.getDeviceId());

        UserModel saved = userRepository.save(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRegistrationDate(),
                saved.getDeviceId()
        );
    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        UserModel user = userRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(loginRequestDTO.getEmail()))
                .findFirst()
                .orElse(null);
        if (user == null) {
            return null;
        }
        String hashedPassword = hashPassword(loginRequestDTO.getPassword());
        if (!user.getPasswordHash().equals(hashedPassword)) {
            return null;
        }
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRegistrationDate(),
                user.getDeviceId()
        );
    }

    @Override
    public UserResponseDTO getById(Long id) {
        Optional<UserModel> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            return null;
        }
        UserModel user = userOpt.get();
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRegistrationDate(),
                user.getDeviceId()
        );
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO updateDTO) {
        Optional<UserModel> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            return null;
        }
        UserModel user = userOpt.get();

        if (updateDTO.getName() != null && !updateDTO.getName().isEmpty()) {
            user.setName(updateDTO.getName());
        }
        if (updateDTO.getEmail() != null && !updateDTO.getEmail().isEmpty()) {
            user.setEmail(updateDTO.getEmail());
        }
        if (updateDTO.getPassword() != null && !updateDTO.getPassword().isEmpty()) {
            user.setPasswordHash(hashPassword(updateDTO.getPassword()));
        }
        if (updateDTO.getDeviceId() != null && !updateDTO.getDeviceId().isEmpty()) {
            user.setDeviceId(updateDTO.getDeviceId());
        }

        UserModel saved = userRepository.save(user);

        return new UserResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getRegistrationDate(),
                saved.getDeviceId()
        );
    }
}