import { Component } from '@angular/core';
import { Car } from '../model/car';
import { CarService } from '../car.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-by-id',
  templateUrl: './update-by-id.component.html',
  styleUrls: ['./update-by-id.component.css']
})
export class UpdateByIdComponent {
  constructor(private carService: CarService, private router: Router) {}

  carId: number = 0;
  car: Car | undefined;  // Use null to indicate no car found
  updateCar: Car = {
    id: 0,
    name: '',
    year: 0,
    sellingPrice: 0,
    kmDriver: 0,
    fuel: '',
    sellerType: '',
    transmission: '',
    owner: ''
  };

  fetchCarById() {
    this.carService.getCarById(this.carId).subscribe((result) => (this.car = result));
    }

  updateCarById() {
    this.carService.updateCarById(this.carId, this.updateCar).subscribe(
      (result) => {
        (this.car = result),
          alert("Car details updated");
      }
    );
  }

  goHome() {
    this.router.navigate(['/home']);
  }
}

