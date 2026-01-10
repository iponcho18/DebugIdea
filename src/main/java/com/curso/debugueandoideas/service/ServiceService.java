package com.curso.debugueandoideas.service;

import com.curso.debugueandoideas.dto.DtoService;
import com.curso.debugueandoideas.entity.ServiceEntity;
import com.curso.debugueandoideas.exception.NotFoundException;
import com.curso.debugueandoideas.mapper.ServiceMapper;
import com.curso.debugueandoideas.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ServiceService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public DtoService getService (String s){
        return serviceRepository.findById(s).map(serviceMapper::toDto).orElseThrow(() -> new NotFoundException("Servicio no encontredo"+s));
    }
}
