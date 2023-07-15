import { Component, OnInit, Injectable } from '@angular/core';
import { RestaurantsService } from '../../Service/restaurant.service';
import {Router, ActivatedRoute} from '@angular/router'
@Component({
  selector: 'mt-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})

export class ReviewComponent implements OnInit {

  reviews: any = [];
  constructor(private restaurantService: RestaurantsService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.restaurantService.reviewsOfRestaurant(this.route.parent.snapshot.params['id']).subscribe(
      reviews => this.reviews = reviews
    )


  }

  

}
