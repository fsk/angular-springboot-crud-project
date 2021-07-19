import { Employee } from './../employee';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] | undefined;

  constructor(
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees() {
    this.employeeService.getEmployeeList().subscribe((data) => {
      this.employees = data;
    });
  }

  updateEmployee(id: number) {
    this.router.navigate(['update-employee', id]);
  }

  deleteEmployee(id: number) {
    if (confirm('Veriyi Silmek istediginize emin misiniz.?')) {
      this.employeeService.deleteEmployeeById(id).subscribe(
        (data) => {
          console.log(data);
          this.getEmployees();
        },
        (err) => console.log(err)
      );
    } else {
    }
  }

  deleteAllEmployees() {
    if (confirm('Butun verileri silmek istediginize emin misiniz.?')) {
      this.employeeService.deleteAllEmployees().subscribe(
        (data) => {
          this.getEmployees();
        },
        (err) => console.log(err)
      );
    } else {
    }
  }

  employeeDetails(id: number) {
    this.router.navigate(['employee-details', id])
    
  }
}
