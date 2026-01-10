package com.curso.debugueandoideas.mapper;

import com.curso.debugueandoideas.dto.DtoService;
import com.curso.debugueandoideas.entity.ServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {
    DtoService toDto(ServiceEntity service);
}
