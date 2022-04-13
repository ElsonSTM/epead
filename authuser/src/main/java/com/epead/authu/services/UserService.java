package com.epead.authu.services;

import com.epead.authu.models.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserModel> findAll();
    Optional<UserModel> findById(UUID userId);

    void delete(UserModel userModel);
}
