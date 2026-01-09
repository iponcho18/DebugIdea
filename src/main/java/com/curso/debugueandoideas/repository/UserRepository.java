package com.curso.debugueandoideas.repository;

import com.curso.debugueandoideas.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
