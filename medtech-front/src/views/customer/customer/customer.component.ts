import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import { LoadingService } from 'services/loading.service';
import {CustomerService} from "../../../services/customer.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  constructor(private activateRoute: ActivatedRoute,private loadSvc:LoadingService,  private service: CustomerService) { }
  public customer:any = {};

  ngOnInit(): void {
    this.activateRoute.params.subscribe(
      params => {
        const id = params['id'];
        if(id){
          this.load(id);
        }
      });
  }


  private load(id: any) {
    this.loadSvc.start();
    this.service.get(id).subscribe(res =>{
      this.customer = res
      this.loadSvc.end();
    })
      
    // this.customer ={
      //   id:12312,
      //   name:"Lucas",
      //   email:"lucas@teste.com",
      //   phone:"11963841561",
      //   active: true,
      //   details:"asdasdasdasdasdasdasdasdasdas"
      // }
  }


  update() {
    this.loadSvc.start();

    this.service.save(this.customer).subscribe(res => {
      this.customer = res;
      this.loadSvc.end();

    });
  }
}
