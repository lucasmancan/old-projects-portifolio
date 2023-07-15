import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { RestaurantsService } from '../../Service/restaurant.service';
import { ActivatedRoute } from '../../../../node_modules/@angular/router';
import { ShoppingCartService } from '../../Service/shoppingCart.service';

@Component({
  selector: 'mt-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {


  menu: any;
  @Output() add = new EventEmitter();


  constructor(private restaurantService: RestaurantsService,
              private route: ActivatedRoute,
              private shoppingCart: ShoppingCartService) { }

  ngOnInit() {
    this.loadMenu(this.route.parent.snapshot.params['id']);
  }

  loadMenu(id: string){
    return this.restaurantService.menuOfRestaurant(id).
    subscribe( menu => this.menu = menu);
  }

  addMenuItem(item: any){
    //this.add.emit(item);
    this.shoppingCart.add(item);
  console.log(item);
  }

}
