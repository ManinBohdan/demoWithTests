package com.example.demowithtests.util;

import com.example.demowithtests.EmployeeDTO.EmployeeDTO;
import com.example.demowithtests.domain.Employee;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class ConfigurationDTO extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Employee.class, EmployeeDTO.class)
                .byDefault()
                .register();
    }
}
