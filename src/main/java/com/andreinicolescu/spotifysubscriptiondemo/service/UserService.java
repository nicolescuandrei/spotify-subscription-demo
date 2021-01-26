package com.andreinicolescu.spotifysubscriptiondemo.service;

import com.andreinicolescu.spotifysubscriptiondemo.entity.UserEntity;
import com.andreinicolescu.spotifysubscriptiondemo.repository.UserRepository;
import com.andreinicolescu.spotifysubscriptiondemo.resource.dto.UserDTO;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final Mapper mapper;

    public UserEntity getUser(String email) {
        return this.userRepository.findByEmail(email);
    }

    public void saveUser(UserDTO userDTO) {
        UserEntity userEntity = this.mapper.map(userDTO, UserEntity.class);
        try {
            this.userRepository.save(userEntity);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists", dataIntegrityViolationException);
        }
    }
}
