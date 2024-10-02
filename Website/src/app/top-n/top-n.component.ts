import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CarService } from '../car.service';
import { Car } from '../model/car';

@Component({
  selector: 'app-top-n',
  templateUrl: './top-n.component.html',
  styleUrl: './top-n.component.css'
})
export class TopNComponent {
  car: Car | undefined;
  cars: Car[] = [];
  topCars: Car[] = [];
  n: number = 0;
  constructor(private carService: CarService, private router:Router) {}

  fetchTopNCars() {
    this.carService.getTopNCars(this.n).subscribe((result) => (this.topCars = result));
  }
  goHome() {
    this.router
      .navigate(['/home'])
  }
}
