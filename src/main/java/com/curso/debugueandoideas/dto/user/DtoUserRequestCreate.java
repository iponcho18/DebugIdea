package com.curso.debugueandoideas.dto.request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoUserRequestCreate {

    @NotBlank(message = "{user.name.empty}")
    @Size(min = 1, max = 150, message = "{user.name.size}")
    private String name;


    @NotBlank(message = "{user.age.empty}")
    @Min(value = 0, message = "{user.age.min}")
    @Max(value = 100, message = "{user.age.max}")
    private Integer age;

    @NotBlank(message = "{user.email.empty}")
    @Email(message = "{user.email.invalid}")
    private String mail;
}
