import { Employee } from './employee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private baseURL = 'http://localhost:1905/employee';

  constructor(private httpClient: HttpClient) {}

  getEmployeeList(): Observable<Employee[]> {
    return this.httpClient.get<Employee[]>(`${this.baseURL}/get-all-employees`);
  }

  insertEmployee(employee: Employee): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}/insert-employee`, employee);
  }


  getEmployeeByID(id:number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${this.baseURL}/get-employee-by-id/${id}`);
  }

  updateEmployeeById(id: number, employee: Employee): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/update-employee-by-id/${id}`, employee);
  }


  deleteEmployeeById(id: number) : Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/delete-employee-by-id/${id}`);
  }

  deleteAllEmployees() : Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/delete-all-employees`);
  }
}
