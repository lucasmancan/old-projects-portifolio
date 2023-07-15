import { Routes } from '@angular/router';
import { DashboardComponent } from '../../dashboard/dashboard.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard', loadChildren: () => import('views/dashboard/dashboard.module').then(m => m.DashboardModule) },
    { path: 'pacientes', loadChildren: () => import('views/customer/customer.module').then(m => m.CustomerModule) },
    { path: 'receitas', loadChildren: () => import('views/prescription/prescription.module').then(m => m.PrescriptionModule) },
    { path: 'medicamentos', loadChildren: () => import('views/drug/drug.module').then(m => m.DrugModule) },
    { path: 'configuracoes', loadChildren: () => import('views/configuration/configuration.module').then(m => m.ConfigurationModule) },

];
