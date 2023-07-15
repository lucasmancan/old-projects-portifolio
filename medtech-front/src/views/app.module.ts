import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {ToastrModule} from "ngx-toastr";

import {SidebarModule} from './sidebar/sidebar.module';
import {FooterModule} from './shared/footer/footer.module';
import {NavbarModule} from './shared/navbar/navbar.module';
import {FixedPluginModule} from './shared/fixedplugin/fixedplugin.module';

import {AppComponent} from './app.component';
import {AppRoutes, AuthGuardService} from './app.routing';

import {AdminLayoutComponent} from './layouts/admin-layout/admin-layout.component';
import {AuthService} from '../services/auth.service';
import {LoadingService} from '../services/loading.service';
import {AppService} from '../services/app.service';
import {DrugService} from '../services/drug.service';
import {PrescriptionService} from '../services/prescription.service';
import {CustomerService} from '../services/customer.service';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AppInterceptor} from './app.interceptor';
import {NgxMaskModule} from "ngx-mask";
import { NgxSpinnerModule } from "ngx-spinner";
import { registerLocaleData } from '@angular/common';
import localePt from '@angular/common/locales/pt';
import { LOCALE_ID } from '@angular/core';

registerLocaleData(localePt);
// export const options: Partial<IConfig> | (() => Partial<IConfig>);


@NgModule({
  declarations: [
    AppComponent,
    AdminLayoutComponent
  ],
  imports: [
    BrowserAnimationsModule,
    RouterModule.forRoot(AppRoutes, {
      useHash: true
    }),
    SidebarModule,
    FormsModule,
    NgxSpinnerModule,
    NavbarModule,
    ToastrModule.forRoot(),
    FooterModule,
    HttpClientModule,
    FixedPluginModule,
    NgxMaskModule.forRoot()
  ],
  providers: [AuthService, LoadingService, AppService, DrugService, PrescriptionService, CustomerService, AuthGuardService, {
    provide: HTTP_INTERCEPTORS,
    useClass: AppInterceptor,
    multi: true,
  },{ provide: LOCALE_ID, useValue: 'pt'}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
