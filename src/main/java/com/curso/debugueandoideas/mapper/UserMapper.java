package com.curso.debugueandoideas.mapper;

import com.curso.debugueandoideas.dto.user.DtoUserRequestCreate;
import com.curso.debugueandoideas.dto.user.DtoUserRequestUpdate;
import com.curso.debugueandoideas.dto.user.DtoUserResponse;
import com.curso.debugueandoideas.entity.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    DtoUserResponse toDtoResponse(UserEntity user);

    @Mapping(target = "id", ignore = true)
    UserEntity createEntity(DtoUserRequestCreate requestCreate);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(DtoUserRequestUpdate requestUpdate, @MappingTarget UserEntity user);
}