import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { InsertEmployeeComponent } from './insert-employee/insert-employee.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'employees', component: EmployeeListComponent },
  { path: '', redirectTo: 'employees', pathMatch: 'full' },
  { path: 'insert-employee', component: InsertEmployeeComponent },
  { path: 'update-employee/:id', component: UpdateEmployeeComponent },
  { path: 'employee-details/:id', component: EmployeeDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
