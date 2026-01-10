package com.curso.debugueandoideas.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;


@Entity
@Table(name = "service")
@Log4j2
@Data
public class ServiceEntity {

    @Id
    @Column(name = "service_id", length = 100)
    private String Id;

    @Column(name = "service_description", length = 200)
    private String Description;

    @Column(name = "service_host", length = 80)
    private String Host;

    @Column(name = "service_port")
    private Integer Port = 0;

    @Column(name = "service_secure")
    private Integer Secure = 0;

    @Column(name = "service_timeout")
    private Integer Timeout = 5;

    @Column(name = "service_baseurl", length = 200)
    private String Baseurl;

    @Column(name = "service_name", length = 100)
    private String Name;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_method", nullable = false, length = 20)
    private ServiceMethod Method;
}

