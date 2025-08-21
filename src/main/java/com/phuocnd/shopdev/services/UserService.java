package com.phuocnd.shopdev.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.phuocnd.shopdev.entities.user.UserEntity;

@Service
public interface UserService {
    UserEntity createUser(UserEntity userEntity);

    List<UserEntity> getAllUsers();

    // Get All Limit Offets
    Page<UserEntity> findAllUsers(Pageable pageable);

    Page<UserEntity> findByUsername(String username, Pageable pageable);
}
