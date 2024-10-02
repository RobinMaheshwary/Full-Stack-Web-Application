import { Component } from '@angular/core';
import { Car } from '../model/car';
import { CarService } from '../car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-data',
  templateUrl: './show-data.component.html',
  styleUrl: './show-data.component.css',
})
export class ShowDataComponent {
  carId: number = 0;
  car: Car | undefined;
  cars: Car[] = [];
  topCars: Car[] = [];
  n: number = 0;

  updateCar: Car = {
    id: 0,
    name: '',
    year: 0,
    sellingPrice: 0,
    kmDriver: 0,
    fuel: '',
    sellerType: '',
    transmission: '',
    owner: '',
  };

  constructor(private carService: CarService, private router:Router) {}

  // fetchCarById() {
  //   this.carService
  //     .getCarById(this.carId)
  //     .subscribe((result) => (this.car = result));
  // }

  // updateCarById() {
  //   this.carService
  //     .updateCarById(this.carId, this.updateCar)
  //     .subscribe((result) => (this.car = result));
  // }

  // deleteCarById() {
  //   this.carService.deleteCarById(this.carId).subscribe(() => {
  //     this.car = undefined;
  //     alert('Car deleted');
  //   });
  // }

  fetchAllCars() {
    this.carService
      .getAllCars()
      .subscribe((result) => (this.cars = result));
  }

  // fetchTopNCars() {
  //   this.carService
  //     .getTopNCars(this.n)
  //     .subscribe((result) => (this.topCars = result));
  // }

  goHome() {
    this.router
      .navigate(['/home'])
  }
}
