package com.curso.debugueandoideas.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;


@Entity
@Table(name = "service")
@Log4j2
@Data
public class ServiceEntity {

    @Id
    @Column(name = "service_id", length = 100)
    private String id;

    @Column(name = "service_description", length = 200)
    private String description;

    @Column(name = "service_host", length = 80)
    private String host;

    @Column(name = "service_port")
    private Integer port = 0;

    @Column(name = "service_secure")
    private Integer secure = 0;

    @Column(name = "service_timeout")
    private Integer timeout = 5;

    @Column(name = "service_baseurl", length = 200)
    private String baseurl;

    @Column(name = "service_name", length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_method", nullable = false, length = 20)
    private HttpMethod method = HttpMethod.GET;
}

