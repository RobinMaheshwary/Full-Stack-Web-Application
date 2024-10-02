import { Component } from '@angular/core';
import { Car } from '../model/car';
import { CarService } from '../car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-car-id',
  templateUrl: './get-car-id.component.html',
  styleUrl: './get-car-id.component.css'
})
export class GetCarIdComponent {
  car: Car | undefined;
  carId: number = 0;
  constructor(private carService: CarService, private router:Router) {}

  fetchCarById() {
  this.carService.getCarById(this.carId).subscribe((result) => (this.car = result));
  }

  goHome() {
    this.router
      .navigate(['/home'])
  }
}
