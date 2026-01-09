package com.curso.debugueandoideas.repository;

import com.curso.debugueandoideas.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity, String> {
}
