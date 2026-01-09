package com.curso.debugueandoideas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

import javax.lang.model.element.Name;

@Entity
@Table(name = "property")
@Data
@Log4j2
public class PropertyEntity {

    @Id
    @Column(name = "property_id", length = 100)
    private String id;

    @Column(name = "property_value", length = 1000)
    private String value;
}
