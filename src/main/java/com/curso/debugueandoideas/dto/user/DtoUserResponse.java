package com.curso.debugueandoideas.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoUserResponse {
    private Long id;
    private String name;
    private Integer age;
    private String mail;
    private Instant createAt;
    private Instant updateAt;
}
