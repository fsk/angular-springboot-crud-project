package com.vektorel.fullbackendproject.controllers;

import com.vektorel.fullbackendproject.apipaths.EmployeePaths;
import com.vektorel.fullbackendproject.models.Employee;
import com.vektorel.fullbackendproject.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = EmployeePaths.BASE_URL)
@RequiredArgsConstructor
@Api(value = "Employee Controller")
public class EmployeeController {

    private final EmployeeService employeeService;


    @PostMapping(value = EmployeePaths.INSERT_EMPLOYEE)
    @ApiOperation(value = "Insert", notes = "Gelen employeeu ekleme islemi yapan API.")
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.insertEmployee(employee));
    }

    @GetMapping(value = EmployeePaths.GET_ALL_EMPLOYEES)
    @ApiOperation(value = "Read", notes = "DBdeki butun employeelari getirir.")
    public List<Employee> getAllUsers() {
        return employeeService.getAllUsers();
    }

    @GetMapping(value = EmployeePaths.GET_EMPLOYEE_BY_ID + "{id}")
    @ApiOperation(value = "Read By Id", notes = "ID degerine gore Employee getirme islemi yapan API.")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @DeleteMapping(value = EmployeePaths.DELETE_ALL_EMPLOYEES)
    @ApiOperation(value = "Delete", notes = "Butun Employeelari silme islemi yapan API.")
    public ResponseEntity deleteAllEmployees() {
        return ResponseEntity.ok(employeeService.deleteAllEmployees());
    }

    @DeleteMapping(value = EmployeePaths.DELETE_EMPLOYEE_BY_ID + "{id}")
    @ApiOperation(value = "Delete by Id", notes = "ID degerine gore Employee silme islemi yapan API.")
    public void deleteEmployeeById(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployeeById(id);
    }


    @PutMapping(value = EmployeePaths.UPDATE_EMPLOYEE_BY_ID + "{id}")
    @ApiOperation(value = "Update by Id", notes = "ID degerine gore Employee guncelleme islemi yapan API.")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "id") Long id, @RequestBody Employee updatedEmployee) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id, updatedEmployee));
    }


}
