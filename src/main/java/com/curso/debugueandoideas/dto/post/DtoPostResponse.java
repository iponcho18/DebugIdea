package com.curso.debugueandoideas.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoPostResponse {
    private String content;
    private String img;
    private Instant createAt;
    private Instant updateAt;
}
