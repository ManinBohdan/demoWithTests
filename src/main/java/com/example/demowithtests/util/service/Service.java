package com.example.demowithtests.util.service;

import com.example.demowithtests.EmployeeDTO.EmployeeDTO;
import com.example.demowithtests.domain.Employee;

import java.util.List;

public interface Service {

    Employee create(Employee employee);

    List<Employee> getAll();
    List<Employee> getAllByCountry(String country);

    Employee getById(Integer id);

    Integer getAmountOfUsersFromSelectedCountry(String country);
    List<Employee> getUsersBySelectedMailSystem(String mailSystem);

    Employee updateById(Integer id, Employee plane);

    void removeById(Integer id);

    void removeAll();

}
