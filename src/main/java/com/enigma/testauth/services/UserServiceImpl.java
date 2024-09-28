package com.enigma.testauth.services;

import com.enigma.testauth.dto.UserEntityDto;
import com.enigma.testauth.entities.UserEntity;
import com.enigma.testauth.mappers.UserEntityMapper;
import com.enigma.testauth.repositories.UserEntityRepository;
import com.enigma.testauth.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserEntityRepository userEntityRepository;

//    public UserServiceImpl(UserEntityRepository userEntityRepository) {
//        this.userEntityRepository = userEntityRepository;
//    }

    @Override
    public List<UserEntityDto> getAllUser() {
        List<UserEntity> userEntityList = this.userEntityRepository.findAll();

        return userEntityList.stream()
                .map(UserEntityMapper.INSTANCE::mapToUserEntityDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserEntityDto createUser(UserEntityDto user) {
        UserEntity userEntity = UserEntityMapper.INSTANCE.mapToUserEntity(user);
               UserEntity userEntityCreated = UserEntity.builder()
                .name(userEntity.getName())
                .password(userEntity.getPassword())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
               UserEntity userEntitySaved = userEntityRepository.save(userEntityCreated);
        return UserEntityMapper.INSTANCE.mapToUserEntityDto(userEntitySaved);
    }
}
