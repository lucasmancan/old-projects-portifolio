import { Component, OnInit } from '@angular/core';
import { AuthService } from 'services/auth.service';
import { Router } from '@angular/router';


export interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
    visible?: boolean
}

export const ROUTES: RouteInfo[] = [
    // { path: '/dashboard',     title: 'Dashboard',         icon:'nc-bank',       class: '' , visible: true},
    { path: '/receitas',         title: 'Receitas',      icon:'nc-paper',    class: '', visible: true },
    { path: '/pacientes',         title: 'Pacientes',      icon:'nc-book-bookmark',    class: '', visible: true },
    // { path: '/paciente',         title: 'Paciente',    icon:'nc-book-bookmark',    class: '', visible: false },
    // { path: '/medicamento',         title: 'Medicamento',    icon:'nc-book-bookmark',    class: '', visible: false },
    // { path: '/receita',         title: 'Receita',    icon:'nc-book-bookmark',    class: '', visible: false },

    // { path: '/icons',         title: 'Icons',             icon:'nc-diamond',    class: '' },
    { path: '/medicamentos',         title: 'Medicamentos',      icon:'nc-box',    class: '', visible: true },
    { path: '/configuracoes',         title: 'Configurações',      icon:'nc-settings',    class: '', visible: true },
    // { path: '/maps',          title: 'Maps',              icon:'nc-pin-3',      class: '' },
    // { path: '/notifications', title: 'Notifications',     icon:'nc-bell-55',    class: '' },
    // { path: '/user',          title: 'User Profile',      icon:'nc-single-02',  class: '' },
    // { path: '/table',         title: 'Table List',        icon:'nc-tile-56',    class: '' },
    // { path: '/typography',    title: 'Typography',        icon:'nc-caps-small', class: '' },
    // { path: '/upgrade',       title: 'Upgrade to PRO',    icon:'nc-spaceship',  class: 'active-pro' },
];

@Component({
    moduleId: module.id,
    selector: 'sidebar-cmp',
    templateUrl: 'sidebar.component.html',
})

export class SidebarComponent implements OnInit {
    public menuItems: any[];

    constructor(private router: Router){}

    ngOnInit() {
        this.menuItems = ROUTES.filter(menuItem => menuItem);
    }

    public logout(){
        this.router.navigate(['/auth/entrar']).then(() =>  localStorage.clear());
    }
}
