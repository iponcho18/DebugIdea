package com.curso.debugueandoideas.dto.page;

import com.curso.debugueandoideas.dto.post.DtoPostResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoPageResponse {
    private String title;
    private List<DtoPostResponse> posts;
    private Instant createAt;
    private Instant updateAt;
}
