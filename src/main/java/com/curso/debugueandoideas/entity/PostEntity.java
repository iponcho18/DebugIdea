package com.curso.debugueandoideas.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Log4j2
@Data
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="content", length = 300 )
    private String content;

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

    @Column(name="img", length = 255 )
    private String img;
}
