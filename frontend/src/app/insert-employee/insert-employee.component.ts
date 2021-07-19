import { Router } from '@angular/router';
import { EmployeeService } from './../employee.service';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-insert-employee',
  templateUrl: './insert-employee.component.html',
  styleUrls: ['./insert-employee.component.css'],
})
export class InsertEmployeeComponent implements OnInit {
  title = 'Insert Employee';
  employee: Employee = new Employee();

  constructor(
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  insertEmployee() {
    this.employeeService.insertEmployee(this.employee).subscribe(
      (data) => {
        console.log(data);
        this.goToEmployeeList();
      },
      (err) => console.log(err)
    );
  }


  goToEmployeeList() {
    this.router.navigate(['/employees'])
  }

  onSubmit() {
    this.insertEmployee();
  }
}
