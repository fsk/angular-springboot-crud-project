package com.vektorel.fullbackendproject.repositories;

import com.vektorel.fullbackendproject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //@Query(value = "SELECT * FROM Employee ", nativeQuery = true)
    Optional<Employee> findByEmailLike(String email);
    


}
