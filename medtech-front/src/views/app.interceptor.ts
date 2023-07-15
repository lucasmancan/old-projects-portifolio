import {Injectable} from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpResponse, HttpErrorResponse
} from '@angular/common/http';
import {AuthService} from '../services/auth.service';
import {Observable, throwError} from 'rxjs';
import {catchError, map} from "rxjs/operators";
import {LoadingService} from "../services/loading.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";


@Injectable()
export class AppInterceptor implements HttpInterceptor {

  static readonly OOPS_TITLE: string = 'Oops! ';
  static readonly OOPS_MESSAGE: string = 'Ocorreu uma erro. Verifique sua conexão com a Internet e tente novamente.';

  constructor(public auth: AuthService, private toastr: ToastrService, private router: Router, private loadingService: LoadingService) {}

  showError(response: HttpErrorResponse): Observable<any> {
    this.loadingService.end();

    if (response.status == 401 || response.status == 403) {
      this.router.navigate(["/auth"])
      return throwError(response);
    }

    let message = null;

    if(response.error){
      message = response.error.message;
    }

    this.toastr.error(message || AppInterceptor.OOPS_MESSAGE, AppInterceptor.OOPS_TITLE)

    return throwError(response);
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {


    const token = this.auth.getToken();

    if(token){
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${this.auth.getToken()}`
        }
      });  
    }
   
    return next.handle(request).pipe(
      map((response: HttpResponse<any>) => {
        if (response.status > 399) {
          throw response;
        }

        return response;
      }),
      catchError(error => this.showError(error)));
  }
}
