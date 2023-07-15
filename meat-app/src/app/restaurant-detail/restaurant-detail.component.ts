import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../Model/restaurant.model';
import { RestaurantsService } from '../Service/restaurant.service';
import { ActivatedRoute } from '../../../node_modules/@angular/router';

@Component({
  selector: 'mt-restaurant-detail',
  templateUrl: './restaurant-detail.component.html',
  styleUrls: ['./restaurant-detail.component.css']
})
export class RestaurantDetailComponent implements OnInit {

  restaurant: Restaurant;
  constructor(private restaurantService: RestaurantsService, private route: ActivatedRoute) { }

  ngOnInit() {
    console.log(this.restaurantService.restaurantById(this.route.snapshot.params['id']));
    return this.restaurantService.restaurantById(this.route.snapshot.params['id'])
    .subscribe(restaurant => this.restaurant = restaurant );
  }

}
