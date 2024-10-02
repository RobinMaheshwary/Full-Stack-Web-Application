import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { HomeComponent } from './home/home.component';
import { ShowDataComponent } from './show-data/show-data.component';
import { CarService } from './car.service';
import { LoginComponent } from './authenticate/login/login.component';
import { RegisterComponent } from './authenticate/register/register.component';
import { GetCarIdComponent } from './get-car-id/get-car-id.component';
import { TopNComponent } from './top-n/top-n.component';
import { DeleteByIdComponent } from './delete-by-id/delete-by-id.component';
import { UpdateByIdComponent } from './update-by-id/update-by-id.component';
import { ErrorComponent } from './error/error.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ShowDataComponent,
    LoginComponent,
    RegisterComponent,
    GetCarIdComponent,
    GetCarIdComponent,
    TopNComponent,
    DeleteByIdComponent,
    UpdateByIdComponent,
    ErrorComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [provideAnimationsAsync(), CarService],
  bootstrap: [AppComponent],
})
export class AppModule {}
