package com.enigma.testauth.services.interfaces;

import com.enigma.testauth.dto.UserEntityDto;
import com.enigma.testauth.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<UserEntityDto> getAllUser();
    UserEntityDto createUser(UserEntityDto user);
}
