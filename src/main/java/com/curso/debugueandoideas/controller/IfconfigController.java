package com.curso.debugueandoideas.controller;

import com.curso.debugueandoideas.dto.service.IfconfigAllResponse;
import com.curso.debugueandoideas.service.IfconfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IfconfigController {

    private final IfconfigService ifconfigService;

    @GetMapping("/ifconfig")
    public IfconfigAllResponse ifconfig() {
        return ifconfigService.getAll().getData();
    }
}
