package com.curso.debugueandoideas.repository;

import com.curso.debugueandoideas.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, String> {
}
