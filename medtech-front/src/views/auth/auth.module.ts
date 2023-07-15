import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { VerifyEmailComponent } from './verify-email/verify-email.component';
import { FormsModule } from '@angular/forms';
import { InitialFooterComponent } from 'views/initial-footer/initial-footer.component';
import { NgxMaskModule } from 'ngx-mask';


export const routes: Routes = [
  {
    path: "",
    redirectTo: 'entrar',
    pathMatch: 'full'
  },
  {
    path: 'entrar',
    component: LoginComponent
  }, {
    path: 'registrar',
    component: RegisterComponent
  }
]


@NgModule({
  declarations: [
    LoginComponent,
    ChangePasswordComponent,
    VerifyEmailComponent,
    RegisterComponent,InitialFooterComponent
  ],
  imports: [
    CommonModule,
      FormsModule,
     RouterModule.forChild(routes),
     
    NgxMaskModule.forRoot()
  ]
})
export class AuthModule { }
