import { EmployeeService } from './../employee.service';
import { Employee } from './../employee';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css'],
})
export class UpdateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  title = 'Update Employee';
  id!: number;
  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.employeeService.getEmployeeByID(this.id).subscribe(
      (data) => {
        this.employee = data;
      },
      (err) => console.log(err)
    );
  }

  onSubmit() {
    this.employeeService.updateEmployeeById(this.id, this.employee).subscribe(
      (data) => {
        this.goToEmployeeList();
      },
      (err) => console.log(err)
    );
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }
}
