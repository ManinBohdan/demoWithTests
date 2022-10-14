package com.example.demowithtests.repository;

import com.example.demowithtests.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
//@Component
public interface Repository extends JpaRepository<Employee, Integer> {

    Employee findByName(String name);
    List<Employee> findAllByCountry(String country);
   @Query(value = "select * from users1 WHERE country = ?1 ", nativeQuery = true)
    List<Employee> getAmountOfUsersFromSelectedCountry (String country);

    // Запрос с динамическим подставлением переменной не хочет работать, как было на уроке
    // Не могу понять как вставить переменную в кавычки оператора LIKE, перерыл пол Гугла и ничего пока не смог найти
    //@Query(value = "SELECT * FROM users1 c WHERE c.email LIKE %?1%", nativeQuery = true)
    @Query(value = "SELECT * FROM users1 c WHERE c.email LIKE '%@gmail.com%'", nativeQuery = true)
    List <Employee> getUsersBySelectedMailSystem (String mailSystem);


}
