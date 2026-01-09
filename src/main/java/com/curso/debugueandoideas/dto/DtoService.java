package com.curso.debugueandoideas.dto;

import com.curso.debugueandoideas.entity.ServiceMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoService {
    public String Host;
    public Integer Port;
    public Integer Timeout;
    public Integer Secure;
    public String Baseurl;
    public String Name;
    public ServiceMethod Method;
}
