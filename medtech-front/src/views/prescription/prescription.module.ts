import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {PrescriptionComponent} from './prescription/prescription.component';
import {PrescriptionsComponent} from './prescriptions/prescriptions.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppPaginatorModule} from "../app-paginator/app-paginator.module";
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';



export const DateFormats = {
  parse: {
    dateInput: ['YYYY-MM-DD']
  },
  display: {
    dateInput: 'DD/MM/YYYY',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

export const PrescriptionRoutes: Routes = [
  {
    path: '',
    redirectTo: 'receitas',
    pathMatch: 'full',
  }, {
    path: 'receitas',
    component: PrescriptionsComponent
  }, {
    path: 'receita/:id',
    component: PrescriptionComponent
  },
  {
    path: 'receita',
    component: PrescriptionComponent
  }
];


@NgModule({
  declarations: [
    PrescriptionsComponent,
    PrescriptionComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(PrescriptionRoutes),
    FormsModule,
    ReactiveFormsModule,MatDatepickerModule,MatNativeDateModule,
    AppPaginatorModule
  ]
})
export class PrescriptionModule {
}
