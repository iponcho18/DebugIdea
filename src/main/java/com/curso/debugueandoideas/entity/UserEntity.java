package com.curso.debugueandoideas.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Length;
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
    @Column(name = "udapte_by", nullable = false, length = 150)
    private String udapteBy;

    @OneToOne(mappedBy = "user")
    private PageEntity page;
}
