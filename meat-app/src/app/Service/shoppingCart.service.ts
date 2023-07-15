import { Injectable } from "../../../node_modules/@angular/core";
import { Http } from "../../../node_modules/@angular/http";
import { MEAT_API } from "app.api";
import { Observable } from "../../../node_modules/rxjs/Observable";
import { ErrorHandle } from "../app.error-handler";
import { ShoppingCartItem } from "../Model/shoppingCartItem.model";
import { MenuItem } from "../Model/menuItem.model";

@Injectable()
export class ShoppingCartService {

    shoppinCartItens: any;
    shoppingCartItem:any;
    constructor(private http: Http) {

    }

    getShoppingCartItens(): Observable<any> {
        return this.http.get(`${MEAT_API}/shoppingCartItens`).
            map(Response => Response.json()).
            catch(ErrorHandle.handleError);

    }

    add(item: MenuItem): Observable<any> {

        if (this.findItem(item.id)) {
            return this.http.put(`${MEAT_API}/shoppingCartItens/${item.id}`, item)
        } else {
            return this.http.post(`${MEAT_API}/shoppingCartItens`, item);
        }

    }

    findItem(id: string) {
        return this.shoppinCartItens.
            find(ShoppingCartItem => ShoppingCartItem.menuItem.id === id);
    }


    total() {
        let valueOfCart: number;
        this.shoppinCartItens.forEach(element => {
            valueOfCart = element.value();
        });
        return valueOfCart;
    }

    clear(item: ShoppingCartItem): Observable<any> {
        return this.http.delete(`${MEAT_API}/shoppingCartItens/${item}`);
    }
}