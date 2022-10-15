package com.example.demowithtests;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.repository.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class RepositoryTests {
    @Autowired
    private Repository repository;

    @Test
    @Order(1)
    public void findAllUsersByCountryTest () {
        Employee employee = Employee.builder().country("Ukraine").build();
        repository.save(employee);
        List<Employee> list = repository.findAllByCountry("Ukraine");
        Assertions.assertThat(employee.getCountry().equals("Ukraine"));
    }

    @Test
    @Order(2)
    public void getAmountOfUsersFromSelectedCountryTest () {
        Employee employee1 = Employee.builder().name("firstEmployee").country("Ukraine").build();
        Employee employee2 = Employee.builder().name("secondEmployee").country("Ukraine").build();
        repository.save(employee1);
        repository.save(employee2);
        ArrayList<Employee> list = (ArrayList<Employee>) repository.getAmountOfUsersFromSelectedCountry("Ukraine");
        Assert.assertTrue((list.get(0).getCountry().equals("Ukraine") == list.get(1).getCountry().equals("Ukraine")));
    }

    @Test
    @Order(3)
    public void getUsersBySelectedMailSystemIsBlankTest () {
        Employee employee1 = Employee.builder().name("firstEmployee").country("Ukraine").email("bohdanmanin@gmail.com").build();
        Employee employee2 = Employee.builder().name("secondEmployee").country("Ukraine").email("olegkaliuzhnyi@gmail.com").build();
        repository.save(employee1);
        repository.save(employee2);
//        Employee employee = repository.findById(1).orElseThrow();
//        System.out.println(employee.getEmail());
//        System.out.println(employee.getId());
        ArrayList<Employee> list = (ArrayList<Employee>) repository.getUsersBySelectedMailSystem("@gmail");
        Assert.assertTrue(list.get(0).getEmail().isBlank() == list.get(1).getEmail().isBlank() == true );
    }

    @Test
    @Order(4)
    public void getUsersBySelectedMailSystemIsContainsTest () {
        Employee employee1 = Employee.builder().name("firstEmployee").country("Ukraine").email("bohdanmanin@gmail.com").build();
        //Employee employee2 = Employee.builder().name("secondEmployee").country("Ukraine").email("olegkaliuzhnyi@mailbox.nmu.com").build();
        repository.save(employee1);
        //repository.save(employee2);
//        Employee employee = repository.findById(1).orElseThrow();
//        System.out.println(employee.getEmail());
//        System.out.println(employee.getId());
        ArrayList<Employee> list = (ArrayList<Employee>) repository.getUsersBySelectedMailSystem("@gmail");
        Assert.assertTrue(list.get(0).getEmail().contains("@gmail.com"));
    }

    @Test
    @Order(5)
    public void getUsersBySelectedMailSystemIsNotContainsTest () throws Exception {
        //Employee employee1 = Employee.builder().name("firstEmployee").country("Ukraine").email("bohdanmanin@gmail.com").build();
        Employee employee2 = Employee.builder().name("secondEmployee").country("Ukraine").email("olegkaliuzhnyi@mailbox.nmu.com").build();
        //repository.save(employee1);
        repository.save(employee2);
        ArrayList<Employee> list = (ArrayList<Employee>) repository.getUsersBySelectedMailSystem("@gmail");
        Assert.assertTrue(!list.contains(employee2));
    }
}
