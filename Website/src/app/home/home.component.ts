import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  constructor(private router: Router) { }
  
  goToHome() {
    this.router.navigate(['/home']);
  }
  goToUpdateCarById() {
    this.router.navigate(['/updatebyid']);
  }
  goToDeleteCarById() {
    this.router.navigate(['/deletebyid'])
  }
  goToTopNCar() { 
    this.router.navigate(['/top']) 
  }
  goToGetCarById() {
    this.router.navigate(['/getcarbyid'])
  }
  goToShowData() {
    this.router.navigate(['/show-data'])
  }

}
