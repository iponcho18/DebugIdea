package com.curso.debugueandoideas.mapper;

import com.curso.debugueandoideas.dto.post.DtoPostRequestCreate;
import com.curso.debugueandoideas.dto.post.DtoPostResponse;
import com.curso.debugueandoideas.entity.PostEntity;
import org.mapstruct.*;

@Mapper
public interface PostMapper {
    DtoPostResponse toDtoResponse(PostEntity post);

    @Mapping(target = "id", ignore = true)
    PostEntity createEntity(DtoPostRequestCreate requestCreate);
}
