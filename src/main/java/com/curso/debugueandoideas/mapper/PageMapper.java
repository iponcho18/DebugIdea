package com.curso.debugueandoideas.mapper;

import com.curso.debugueandoideas.dto.page.DtoPageRequestCreate;
import com.curso.debugueandoideas.dto.page.DtoPageRequestUpdate;
import com.curso.debugueandoideas.dto.page.DtoPageResponse;
import com.curso.debugueandoideas.entity.PageEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PageMapper {

    DtoPageResponse toDtoResponse(PageEntity page);

    @Mapping(target = "id", ignore = true)
    PageEntity createEntity(DtoPageRequestCreate requestCreate);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(DtoPageRequestUpdate requestUpdate, @MappingTarget PageEntity page);
}
