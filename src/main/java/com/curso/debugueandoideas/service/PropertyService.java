package com.curso.debugueandoideas.service;

import com.curso.debugueandoideas.entity.PropertyEntity;
import com.curso.debugueandoideas.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public String property(String id) {
        String key = (id == null) ? "" : id.trim();

        String valor = propertyRepository.findById(key)
                .map(PropertyEntity::getValue)
                .orElse("");

        valor = (valor == null) ? "" : valor.trim();

        log.debug("Propiedad {}: {}", key, valor);
        return valor;
    }

    public boolean propertyBool(String id) {
        String valor = property(id).trim();

        boolean b = valor.equals("1") || valor.equalsIgnoreCase("true");

        log.debug("Propiedad bool {}: {}", id, b);
        return b;
    }
}
