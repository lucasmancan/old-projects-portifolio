import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { NavbarComponent } from './navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from "@angular/forms";
import { SearchService } from 'services/search.service';

@NgModule({
    imports: [ RouterModule, CommonModule, NgbModule,FormsModule ],
    declarations: [ NavbarComponent ],
    exports: [ NavbarComponent ],
    providers: [SearchService]
})

export class NavbarModule {}
