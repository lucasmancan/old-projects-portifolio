import { Component, OnInit } from '@angular/core';
import { ShoppingCartService } from '../../Service/shoppingCart.service';
import { ShoppingCartItem } from '../../Model/shoppingCartItem.model';
import { MenuItem } from '../../Model/menuItem.model';

@Component({
  selector: 'mt-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit {

  shoppinCartItens: any;

  constructor(private shoppingCartService: ShoppingCartService) { }

  ngOnInit() {
   this.getItens();
  }

  getItens(){
    return  this.shoppinCartItens = this.shoppingCartService.shoppinCartItens;
  }

  addItem(item: MenuItem){
    this.shoppingCartService.add(item).subscribe(
      this.getItens()
    );
  }

  clear(item: ShoppingCartItem){
      this.shoppingCartService.clear(item).subscribe(
        this.getItens()
      )
  }

}
