import { CanActivate, Router, Routes } from '@angular/router';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { Injectable } from "@angular/core";
import { AuthService } from "../services/auth.service";

@Injectable()
export class AuthGuardService implements CanActivate {
  constructor(public auth: AuthService, public router: Router) {
  }

  canActivate(): boolean {
    if (!this.auth.isAuthenticated()) {
      this.router.navigate(['auth']);
      return false;
    }
    return true;
  }
}

export const AppRoutes: Routes = [
  {
    path: '',
    redirectTo: 'pacientes',
    pathMatch: 'full', canActivate: [AuthGuardService]
  }, {
    path: '',
    component: AdminLayoutComponent, canActivate: [AuthGuardService],
    children: [
      {
        path: '',
        loadChildren: () => import('./layouts/admin-layout/admin-layout.module').then(m => m.AdminLayoutModule)
      }
    ]
  }, {
    path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: '**',
    redirectTo: 'dashboard'
  }
]
