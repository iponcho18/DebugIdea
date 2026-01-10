package com.curso.debugueandoideas.dto.page;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoPageRequestCreate {

    @NotBlank(message = "{page.title.empty}")
    private String title;

    @NotNull(message = "{page.user.empty}")
    private Long userId;
}
