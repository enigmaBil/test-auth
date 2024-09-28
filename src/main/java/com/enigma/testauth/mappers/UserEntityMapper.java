package com.enigma.testauth.mappers;

import com.enigma.testauth.dto.UserEntityDto;
import com.enigma.testauth.entities.UserEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);
    UserEntityDto  mapToUserEntityDto(UserEntity userEntity);

    UserEntity  mapToUserEntity(UserEntityDto userEntityDto);

}