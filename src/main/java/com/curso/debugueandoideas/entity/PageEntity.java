package com.curso.debugueandoideas.entity;

import javax.persistence.*;
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
@Table(name = "page")
@Log4j2
@Data
public class PageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 300, unique = true)
    private String title;

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





    @OneToOne
    @JoinColumn(name = "id_user", unique = true)
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_page")
    private List<PostEntity> posts = new ArrayList<>();

    public void addPost(PostEntity postEntity){
        posts.add(postEntity);
    }

    public void  removePost(PostEntity postEntity){
        posts.remove(postEntity);
    }
}
