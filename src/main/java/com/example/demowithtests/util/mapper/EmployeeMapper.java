package com.example.demowithtests.util.mapper;

import com.example.demowithtests.EmployeeDTO.EmployeeDTO;
import com.example.demowithtests.domain.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
     EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );
     EmployeeDTO toDTO(Employee employee);
}
