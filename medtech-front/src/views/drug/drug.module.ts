import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DrugsComponent } from './drugs/drugs.component';
import { DrugComponent } from './drug/drug.component';
import { Routes, RouterModule } from '@angular/router';
import { SearchService } from 'services/search.service';
import {AppModule} from "../app.module";
import {AppPaginatorModule} from "../app-paginator/app-paginator.module";

export const PrescriptionRoutes: Routes = [
  {
    path: '',
    redirectTo: 'medicamentos',
    pathMatch: 'full',
  }, {
    path: 'medicamentos',
    component: DrugsComponent
  }, {
    path: 'medicamentos/:id',
    component: DrugComponent
  }
];

@NgModule({
  declarations: [DrugsComponent, DrugComponent],
    imports: [
       CommonModule,
        RouterModule.forChild(PrescriptionRoutes),AppPaginatorModule
    ]
})
export class DrugModule { }
