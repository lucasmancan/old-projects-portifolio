import {Injectable} from '@angular/core';

import {AppService} from '../services/app.service';
import {Pageable} from "../models/pageable.model";

@Injectable()
export class DrugService {

  constructor(private appService: AppService) {
  }


  public create(data: any) {
    return this.appService.post('/drugs', data)
  }

  public update(id, data: any) {
    return this.appService.post(`/drugs/${id}`, data)
  }


  public get(id: any) {
    return this.appService.get(`/drugs/${id}`)
  }


  public getAll(paginator: Pageable, search: string) {
    let queryString = ``

    if (paginator) {
      queryString += `?page=${paginator.number}`
    }

    if (search) {
      queryString += `&search=${search}`
    }

    return this.appService.get(`/drugs${queryString}`)
  }


  public delete(id: any) {
    return this.appService.delete(`/drugs/${id}`)
  }

  getAllByName(name: string) {
    let url: string = `/drugs/search`;

    if (name) {
      url += `?name=${name}`;
    }

    return this.appService.get(url)
  }
}
