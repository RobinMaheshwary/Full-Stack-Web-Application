import { Component } from '@angular/core';
import { CarService } from '../car.service';
import { Router } from '@angular/router';
import { Car } from '../model/car';

@Component({
  selector: 'app-delete-by-id',
  templateUrl: './delete-by-id.component.html',
  styleUrl: './delete-by-id.component.css',
})
export class DeleteByIdComponent {
  constructor(private carService: CarService, private router: Router) {}
  carId: number = 0;
  car: Car | undefined;

  deleteCarById() {
    this.carService.deleteCarById(this.carId).subscribe(() => {
      this.car = undefined;
      alert('Car deleted');
    });
    console.log('car deleted');
  }

  goHome() {
    this.router.navigate(['/home']);
  }
}
