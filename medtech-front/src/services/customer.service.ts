import {Injectable} from '@angular/core';

import {AppService} from '../services/app.service';
import {EMPTY, Observable} from "rxjs";
import {Pageable} from "../models/pageable.model";

@Injectable()
export class CustomerService {

  constructor(private appService: AppService) {
  }

  public get(id: any) {
    return this.appService.get(`/customers/${id}`)
  }

  public getAll(paginator: Pageable, search: string) {
    let queryString = ``

    if (paginator) {
      queryString += `?page=${paginator.number}`
    }

    if (search) {
      queryString += `&search=${search}`
    }

    return this.appService.get(`/customers${queryString}`)
  }

  public delete(id: any) {
    return this.appService.delete(`/customers/${id}`)
  }

  save(data: any) {
    return this.appService.post('/customers', data)
  }

  getAllByName(term: string): Observable<any> {

    let url: string = `/customers/search`;


    if (term) {
      url += `?name=${term}`;
    }

    return this.appService.get(url)
  }
}
