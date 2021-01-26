package com.andreinicolescu.spotifysubscriptiondemo.repository;

import com.andreinicolescu.spotifysubscriptiondemo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}
