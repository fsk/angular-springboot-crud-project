import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from './../employee.service';
import { Employee } from './../employee';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css'],
})
export class EmployeeDetailsComponent implements OnInit {
  title = 'Employ Details';
  //employee: Employee = new Employee();
  id!: number;
  employee!: Employee;
  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employee = new Employee();
    this.employeeService.getEmployeeByID(this.id).subscribe(data => {
      this.employee = data;
    })
  }
}
