import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from './model/car';

@Injectable({
  providedIn: 'root',
})
export class CarService {
  private apiUrl = 'http://localhost:8990/cars';

  constructor(private http: HttpClient) {}

  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(`${this.apiUrl}/get/${id}`);
  }

  updateCarById(id: number, car: Car): Observable<Car> {
    return this.http.put<Car>(`${this.apiUrl}/update/${id}`, car);
  }

  deleteCarById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }

  getAllCars(): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/get`);
  }

  getTopNCars(n: number): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.apiUrl}/top/${n}`);
  }
}
