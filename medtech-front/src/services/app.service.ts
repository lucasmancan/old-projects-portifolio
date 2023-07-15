import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {Observable, throwError} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import {LoadingService} from '../services/loading.service';
import {ToastrService} from 'ngx-toastr';
import {ApiOptions} from "../models/api.options";

// import {LoadingService} from './loading.service';

@Injectable()
export class AppService {

  static readonly BASE_URL = environment.baseUrl;
  static readonly NO_AUTH = new HttpHeaders().set('No-Auth', 'True');

  constructor(public http: HttpClient,
              public loadingService: LoadingService, private toastr: ToastrService) {
  }

  get(url: string, options?: ApiOptions): Observable<any> {
    return this.http.get(this.getUrl(url), options);
  }

  delete(url: string, options?: ApiOptions): Observable<any> {
    return this.http.delete(this.getUrl(url), options);
  }

  post(url: string, body: any | null, options?: ApiOptions): Observable<any> {
    return this.http.post(this.getUrl(url), body, options);
  }

  put(url: string, body: any | null, options?: ApiOptions): Observable<any> {
    return this.http.put(this.getUrl(url), body, options);
  }

  private getUrl(endPoint: string): string {
    if (endPoint.startsWith('http:')) {
      return endPoint;
    }

    let url: string = AppService.BASE_URL;

    if (!endPoint.startsWith('/')) {
      endPoint = '/' + endPoint;
    }

    return url += endPoint;
  }
}


export class AppResponse<T> {
  success: boolean;
  message: string;
  data: T;
}

