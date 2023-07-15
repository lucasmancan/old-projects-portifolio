import {Component, OnInit, OnDestroy} from '@angular/core';
import {DrugService} from 'services/drug.service';
import {Router} from '@angular/router';
import {SearchService} from 'services/search.service';
import {Pageable} from "../../../models/pageable.model";

@Component({
  selector: 'app-drugs',
  templateUrl: './drugs.component.html',
  styleUrls: ['./drugs.component.css']
})
export class DrugsComponent implements OnInit, OnDestroy {

  public tableHeaders: any = ["Nome", "Descrição"];
  subscription: any;
  public paginator: Pageable = new Pageable();

  constructor(private service: DrugService, private router: Router, private searchService: SearchService) {
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  ngOnInit(): void {
    this.load(this.paginator);
    this.subscription = this.searchService.getMessage().subscribe(search => {
      this.load(new Pageable(), search.reset ? search.text : null)
    })
  }

  load(paginator: Pageable, string?: string) {
    this.service.getAll(paginator, string).subscribe(res => {
      this.paginator = res;
    })
  }

  delete(data) {
    this.service.delete(data.id).subscribe(res => {
      this.load(this.paginator);
    })
  }
}
