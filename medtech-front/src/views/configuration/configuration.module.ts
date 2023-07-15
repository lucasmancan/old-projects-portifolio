import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {NgxMaskModule} from "ngx-mask";
import { UserComponent } from './user/user.component';

export const ConfigurationRoutes: Routes = [
  // {
  //   path: '',
  //   redirectTo: 'perfil',
  //   pathMatch: 'full',
  // },
   {
    path: '',
    component: UserComponent
  }
];


@NgModule({
  declarations: [UserComponent],
  imports: [
    CommonModule, FormsModule,
    RouterModule.forChild(ConfigurationRoutes), NgxMaskModule
  ]
})
export class ConfigurationModule { }
