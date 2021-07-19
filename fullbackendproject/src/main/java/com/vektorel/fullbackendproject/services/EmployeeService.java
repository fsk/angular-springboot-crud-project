package com.vektorel.fullbackendproject.services;

import com.vektorel.fullbackendproject.exceptions.employee_exceptions.EmployeeAlreadyExistException;
import com.vektorel.fullbackendproject.exceptions.employee_exceptions.EmployeeInvalidEmailException;
import com.vektorel.fullbackendproject.exceptions.employee_exceptions.EmployeeNotFoundException;
import com.vektorel.fullbackendproject.models.Employee;
import com.vektorel.fullbackendproject.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public Employee insertEmployee(Employee employee) {
        if (!isValid(employee.getEmail())) {
            throw new EmployeeInvalidEmailException();
        }

        Optional<Employee> find = employeeRepository.findByEmailLike(employee.getEmail());
        if (!find.isEmpty()) {
            throw new EmployeeAlreadyExistException();
        }

        return employeeRepository.save(employee);
    }


    public List<Employee> getAllUsers() {
        return employeeRepository.findAll();
    }


    private boolean isValid(String email) {
        if (email.contains("@"))
            return true;
        else return false;
    }


    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException();
        }

        return employee.get();

    }

    public ResponseEntity deleteAllEmployees() {
        employeeRepository.deleteAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeById(Long id, Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException());
        employee.setName(updatedEmployee.getName());
        employee.setSurname(updatedEmployee.getEmail());
        if (isValid(updatedEmployee.getEmail())){
            employee.setEmail(updatedEmployee.getEmail());
        }else {
            throw new EmployeeInvalidEmailException();
        }
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setTitle(updatedEmployee.getTitle());

        return employeeRepository.save(employee);

    }
}
