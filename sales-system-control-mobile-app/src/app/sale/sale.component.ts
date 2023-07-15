import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators
} from "@angular/forms";
import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { SalesService } from "src/services/sales.service";
import { AppService } from "src/services/app.service";

@Component({
  selector: "app-sale",
  templateUrl: "./sale.component.html",
  styleUrls: ["./sale.component.scss"]
})
export class SaleComponent implements OnInit {
  public userForm: FormGroup;
  private saleId: any;
  private sale: any = {};
  private user: any = {};
  roles: Array<string> = ["Guest", "Admin", "Owner", "Operator"];
  public saleStatus: string[] = ["PENDENTE", "FINALIZADO", "CANCELADO"];
  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private salesService: SalesService,
    private appService: AppService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      if (params.id) {
        this.loadSale((this.saleId = params.id));
      }
    });
  }

  async loadSale(saleId: any) {
    this.salesService.loadSale(saleId).subscribe(async (res: any) => {
      this.sale = res.data;
    });
  }

  async update() {
    this.salesService.update(this.sale).subscribe(async (res: any) => {
      this.appService.showToast(res.message);
    });
  }

  public onSubmit() {
    this.update();
  }
}
