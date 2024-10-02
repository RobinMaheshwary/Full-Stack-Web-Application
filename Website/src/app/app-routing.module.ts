import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ShowDataComponent } from './show-data/show-data.component';
import { LoginComponent } from './authenticate/login/login.component';
import { RegisterComponent } from './authenticate/register/register.component';
import { AuthGuard } from '../auth.guard';
import { GetCarIdComponent } from './get-car-id/get-car-id.component';
import { TopNComponent } from './top-n/top-n.component';
import { DeleteByIdComponent } from './delete-by-id/delete-by-id.component';
import { UpdateByIdComponent } from './update-by-id/update-by-id.component';
import { ErrorComponent } from './error/error.component';

const routes: Routes = [
  // { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'home', component: HomeComponent },
  { path: 'show-data', component: ShowDataComponent },
  { path: 'getcarbyid', component: GetCarIdComponent },
  { path: 'deletebyid', component: DeleteByIdComponent },
  { path: 'updatebyid', component: UpdateByIdComponent },
  { path: 'top', component: TopNComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', component: ErrorComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
