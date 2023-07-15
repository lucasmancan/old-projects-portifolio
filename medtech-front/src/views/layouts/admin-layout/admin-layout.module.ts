import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {AdminLayoutRoutes} from './admin-layout.routing';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {CustomerModule} from 'views/customer/customer.module';
import {PrescriptionModule} from 'views/prescription/prescription.module';
import {DrugModule} from 'views/drug/drug.module';
import {NgxMaskModule} from "ngx-mask";
import { DashboardComponent } from 'views/dashboard/dashboard.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    NgbModule,
    CustomerModule,
    PrescriptionModule,
    DrugModule,
    NgxMaskModule
  ],
  declarations: [
    DashboardComponent
  ]
})

export class AdminLayoutModule {
}
