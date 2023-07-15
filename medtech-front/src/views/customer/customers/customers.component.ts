import {Component, OnInit, OnDestroy} from '@angular/core';
import {CustomerService} from 'services/customer.service';
import {Router} from '@angular/router';
import {SearchService} from 'services/search.service';
import {Pageable} from "../../../models/pageable.model";
import { LoadingService } from 'services/loading.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit, OnDestroy {

  public tableHeaders: any = ["Nome", "Data de Cadastro", ""];
  subscription: any;
  public paginator: Pageable = new Pageable();

  constructor(private service: CustomerService, private router: Router, private searchService: SearchService, private loadingSvc: LoadingService) {
  }


  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {

    this.subscription = this.searchService.getMessage().subscribe(search => {
      this.load(new Pageable(), search.reset ? search.text : null)
    })

    this.load(this.paginator);
  }

  load(paginator: Pageable, search?: string) {
    this.loadingSvc.start();
    this.service.getAll(paginator, search).subscribe(res => {
      this.paginator = res;
      this.loadingSvc.end();

    })
  }

  delete(data) {
    this.loadingSvc.start();

    this.service.delete(data.id).subscribe(res => {
      this.load(this.paginator);
      this.loadingSvc.end();

    })
  }
}
