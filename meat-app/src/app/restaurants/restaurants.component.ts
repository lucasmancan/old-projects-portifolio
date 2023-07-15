import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../Model/restaurant.model';
import { RestaurantsService } from '../Service/restaurant.service';

@Component({
  selector: 'mt-restaurants',
  templateUrl: './restaurants.component.html',
  styleUrls: ['./restaurants.component.css']
})
export class RestaurantsComponent implements OnInit {

 restaurants: Restaurant[]

  constructor(private restaurantsService: RestaurantsService) { }

  ngOnInit() {
     this.restaurantsService.restaurants().subscribe(restaurants =>this.restaurants = restaurants);
  }

}
