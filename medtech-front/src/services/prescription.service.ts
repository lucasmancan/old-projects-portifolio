import {Injectable} from '@angular/core';

import {AppService} from '../services/app.service';
import {Pageable} from "../models/pageable.model";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class PrescriptionService {
  copy(id: any) {
    return this.appService.get(`/prescriptions/${id}/clone`);
  }

  public sendToCustomer(id: any) {
    return this.appService.get(`/prescriptions/${id}/send`);
  }

  constructor(private appService: AppService) {
  }

  public save(data: any) {
    return this.appService.post('/prescriptions', data)
  }

  public update(id, data: any) {
    return this.appService.post(`/prescriptions/${id}`, data)
  }

  public get(id: any) {
    return this.appService.get(`/prescriptions/${id}`)
  }

  public download(id: any) {

    let headers = new HttpHeaders();
    headers = headers.set('Accept', 'application/pdf');
    return this.appService.get(`/prescriptions/${id}/pdf`, {headers: headers, responseType: 'blob' as 'json'})
  }

  public getAll(paginator: Pageable, search?: string) {
    let queryString = ``

    if (paginator) {
      queryString += `?page=${paginator.number}`
    }

    if (search) {
      queryString += `&search=${search}`
    }

    return this.appService.get(`/prescriptions${queryString}`)
  }

  public delete(id: any) {
    return this.appService.delete(`/prescriptions/${id}`)
  }

  public deleteItem(id: any) {
    return this.appService.delete(`/items/${id}`)
  }

  public saveItem(item: any) {
    return this.appService.post(`/items`, item)
  }

  getItems(id: any) {
    return this.appService.get(`/items/sale/${id}`)
  }
}
