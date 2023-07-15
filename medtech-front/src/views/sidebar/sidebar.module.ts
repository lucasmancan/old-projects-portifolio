import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { SidebarComponent } from './sidebar.component';
import { AuthService } from 'services/auth.service';
import { AppService } from 'services/app.service';

@NgModule({
    imports: [ RouterModule, CommonModule ],
    declarations: [ SidebarComponent ],
    exports: [ SidebarComponent ]
})

export class SidebarModule {}
