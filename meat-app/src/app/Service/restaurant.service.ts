import { Restaurant } from "../Model/restaurant.model";

import { Injectable, ErrorHandler } from "../../../node_modules/@angular/core";
import { Http } from "../../../node_modules/@angular/http";
import { Observable } from "../../../node_modules/rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

import { MEAT_API } from "app.api";
import { ErrorHandle } from "../app.error-handler";

@Injectable()
export class RestaurantsService{

    constructor(private http: Http){}

    restaurants(): Observable<Restaurant[]>{
        return this.http.get(`${MEAT_API}/restaurants`).
        map(response => response.json()).
        catch(ErrorHandle.handleError)
    }

    restaurantById(id: string): Observable<Restaurant>{
            return this.http.get(`${MEAT_API}/restaurants/${id}`).
            map(response => response.json()).
            catch(ErrorHandle.handleError);
    }

    reviewsOfRestaurant(id: string): Observable<any> {
        return this.http.get(`${MEAT_API}/restaurants/${id}/reviews`).
        map(Response =>  Response.json()).
        catch(ErrorHandle.handleError);
    }

    menuOfRestaurant(id: string): Observable<any>{
        return this.http.get(`${MEAT_API}/restaurants/${id}/menu`).
        map(Response => Response.json()).
        catch(ErrorHandle.handleError);

    }
}