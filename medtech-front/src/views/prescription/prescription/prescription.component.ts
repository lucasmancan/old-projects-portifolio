import {AfterViewChecked, Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PrescriptionService} from 'services/prescription.service';
import {DrugService} from 'services/drug.service';
import {CustomerService} from 'services/customer.service';
import {Observable} from "rxjs";
import {debounceTime, distinctUntilChanged, map, startWith} from "rxjs/operators";
import {FormControl} from "@angular/forms";

import { NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { LoadingService } from 'services/loading.service';



@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent implements OnInit, AfterViewChecked {


  public customers: any;
  public drugs: any;
  public items: any;
  private _expiresAt: any;

  constructor(
      private toastrService: ToastrService, private activateRoute: ActivatedRoute,
              private service: PrescriptionService,
              private drugService: DrugService,
              private customerService: CustomerService, private router: Router, private parserFormatter: NgbDateParserFormatter, private loadSvc: LoadingService) {
  }
  ngAfterViewChecked(): void {

  }

  get expiresAt(){
    return this._expiresAt;
  }

  set expiresAt(string){
     this._expiresAt = string;
     this.prescription.expiresAt = this.parserFormatter.format(string);
  }


  public prescription: any = {};
  public prescriptionId: number;

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      params => {
        this.prescriptionId = params['id'];
        if (this.prescriptionId) {
          this.load(this.prescriptionId);
        }
      });

    this.loadCustomersByName();
    this.loadDrugsByName();
  }


  public sendToCustomer(){
    this.loadSvc.start();
    this.service.sendToCustomer(this.prescriptionId).subscribe(res => {
      this.loadSvc.end();

      this.toastrService.success("Receita enviada", "Um e-mail com o documento foi enviado para o paciente");
    })
  }

  private load(id: any) {
    this.loadSvc.start();

    this.service.get(id).subscribe(res => {
      this.prescription = res
      this.loadSvc.end();
    })
  }

  private loadItems(prescriptionId) {
    this.service.getItems(prescriptionId).subscribe(res => {
      this.items = res
    })
  }

  private async deleteItem(itemId) {
    await this.service.deleteItem(itemId).toPromise()
  }

  async update() {

    this.loadSvc.start();

    const prescription = await this.service.save(this.prescription).toPromise();

    this.prescriptionId = prescription.id;
    this.prescription = prescription;
    this.loadSvc.end();


  }

  async addItem() {
    if (!this.prescription.items) {
      this.prescription.items = []
    }

    this.prescription.items.push({})
  }

  async saveItem(item) {
    return await this.service.saveItem(item).toPromise();
  }

  removeItem(item, index) {
    this.prescription.items.splice(index, 1);
  }

  loadCustomersByName(name?: string) {
    this.customerService.getAllByName(name).subscribe(res => this.customers = res);
  }

  loadDrugsByName(name?: string) {
    return this.drugService.getAllByName(name).subscribe(res => {
      this.drugs = res
    });
  }

  download() {
    this.loadSvc.start();
    this.service.download(this.prescriptionId).subscribe(res => {
      const url = window.URL.createObjectURL(res);

      const link = document.createElement('a');
      link.setAttribute('type', 'hidden');
      link.href = url;
      link.download = 'Receita_' + this.prescriptionId + '.pdf';
      document.body.appendChild(link);
      link.click();
      link.remove();
      this.loadSvc.end();

    })
  }
}
