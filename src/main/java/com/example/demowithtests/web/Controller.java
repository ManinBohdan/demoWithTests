package com.example.demowithtests.web;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.util.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    private final Service service;

    //Операция сохранения юзера в базу данных
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee employee) {
        return service.create(employee);
    }

    //Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllUsers() {
        return service.getAll();
    }

    //Получения юзера по id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable Integer id) {

        Employee employee = service.getById(id);
        return employee;
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee refreshEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {

        return service.updateById(id, employee);
    }

    //Удаление по id
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable Integer id) {
        service.removeById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAll();
    }

    // Получение номера телефона юзера по id
    @GetMapping("/users/getPhoneById")
    @ResponseStatus(HttpStatus.OK)
    public String getPhoneNumberByUserId(@RequestBody Employee employeeBody) {
       Employee employee = service.getById(employeeBody.getId());
        return employee.getPhoneNumber();
    }
    // Получение юзера по Стране
    @GetMapping("/users/getUsersByCountry")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getUsersByHisCountry (@Param("country") String country) {
        return service.getAllByCountry(country);
    }
    // Получение числа юзеров из страны
    @GetMapping("/users/getAmountOfUsersFromSelectedCountry")
    @ResponseStatus(HttpStatus.OK)
    public Integer getAmountOfUsersFromSelectedCountry (@Param("country") String country) {
        return service.getAmountOfUsersFromSelectedCountry(country);
    }
    // Получение юзера с определённой почтовой системой
    @GetMapping ("/users/getUsersBySelectedMailSys")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getUsersBySelectedMailSystem (@Param("mailSys") String mailSystem){
        return service.getUsersBySelectedMailSystem(mailSystem);
    }


}





