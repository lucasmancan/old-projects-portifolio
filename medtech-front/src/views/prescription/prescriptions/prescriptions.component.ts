import {Component, OnInit, OnDestroy} from '@angular/core';
import {PrescriptionService} from 'services/prescription.service';
import {Router} from '@angular/router';
import {SearchService} from 'services/search.service';
import {Pageable} from "../../../models/pageable.model";
import { LoadingService } from 'services/loading.service';

@Component({
  selector: 'app-prescriptions',
  templateUrl: './prescriptions.component.html',
  styleUrls: ['./prescriptions.component.css']
})
export class PrescriptionsComponent implements OnInit, OnDestroy {

  public tableHeaders: any = ["Paciente", "Data de Expiração", "Data de Cadastro", "", "", ""];

  public paginator: Pageable = new Pageable();

  private subscription: any;

  constructor(private service: PrescriptionService, private searchService: SearchService,
              private router: Router, private loadingSvc: LoadingService) {
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

  load(paginator: Pageable, search?: string) {
    this.loadingSvc.start();
    this.service.getAll(paginator, search).subscribe((res: Pageable) => {
      this.paginator = res;
      this.loadingSvc.end();
    })
  }

  copy(prescription){
    this.loadingSvc.start();

    this.service.copy(prescription.id).subscribe(res => {
      this.load(this.paginator)
      this.loadingSvc.end();

    }, err => {
      this.loadingSvc.end();
    })
  }

  delete(data) {
    this.service.delete(data.id).subscribe(res => {
      this.load(this.paginator);
    })
  }

  counter(totalPages: number) {
    return new Array(totalPages);
  }

  paginate(item: any) {
    this.paginator.number = item;
    this.load(this.paginator);
  }
}
