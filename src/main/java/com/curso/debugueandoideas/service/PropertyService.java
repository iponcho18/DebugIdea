package com.curso.debugueandoideas.service;

import com.curso.debugueandoideas.entity.PropertyEntity;
import com.curso.debugueandoideas.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class PropertyService {
    private final PropertyRepository propertyRepository;


    public String property(String id){
        String valor = "";
        Optional<PropertyEntity> optional = propertyRepository.findById(id);
        if (optional.isPresent()) {
            valor = optional.get().getValue();
        }
        log.debug("Propiedad {}: {}", id, valor);
        return valor.trim();
    }

    public boolean propertyBool(String id){
        boolean b = false;
        String valor = property(id).toUpperCase();
        if ( valor.equals("1")|| valor.equals("TRUE")){
            b = true;
        }
        log.debug("Propiedad bool {}: {}", id, b);
        return b;
    }
}
