package com.curso.debugueandoideas.repository;

import com.curso.debugueandoideas.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<PostEntity, Long> {
}
