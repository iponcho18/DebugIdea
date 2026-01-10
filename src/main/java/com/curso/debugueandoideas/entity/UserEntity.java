package com.curso.debugueandoideas.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Entity
@Table(name = "usuario")
@Log4j2
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String name;

    private Integer age;

    @Email
    @Column(name = "email", length = 150)
    private String mail;

    @Column(length = 300)
    private String password;

    @CreatedDate
    @Column(name = "create_at", nullable = false, updatable = false)
    private Instant createAt;
    @CreatedBy
    @Column(name = "create_by", nullable = false, updatable = false, length = 150)
    private String createBy;
    @LastModifiedDate
    @Column(name = "update_at", nullable = false)
    private Instant updateAt;
    @LastModifiedBy
    @Column(name = "update_by", nullable = false, length = 150, unique = true)
    private String updateBy;

    @OneToOne(mappedBy = "user")
    private PageEntity page;
}
