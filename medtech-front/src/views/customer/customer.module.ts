import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './customer/customer.component';
import { CustomersComponent } from './customers/customers.component';
import { Routes, RouterModule } from '@angular/router';
import {FormsModule} from "@angular/forms";
import {NgxMaskModule} from "ngx-mask";
import {AppPaginatorComponent} from "../app-paginator/app-paginator.component";
import {AppModule} from "../app.module";
import {AppPaginatorModule} from "../app-paginator/app-paginator.module";


export const CustomerRoutes: Routes = [
  {
    path: '',
    redirectTo: 'pacientes',
    pathMatch: 'full',
  }, {
    path: 'pacientes',
    component: CustomersComponent
  }, {
    path: 'paciente/:id',
    component: CustomerComponent
  },
  {
    path: 'paciente',
    component: CustomerComponent
  }
];


@NgModule({
  declarations: [CustomerComponent, CustomersComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(CustomerRoutes),
    FormsModule,
    NgxMaskModule.forRoot(),AppPaginatorModule
  ]
})
export class CustomerModule { }
