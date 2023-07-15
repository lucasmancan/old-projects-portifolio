import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AppPaginatorComponent} from "./app-paginator.component";


@NgModule({
  declarations: [AppPaginatorComponent],
  imports: [
    CommonModule
  ],exports: [AppPaginatorComponent]
})
export class AppPaginatorModule {
}
