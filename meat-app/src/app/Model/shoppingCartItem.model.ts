import { MenuItem } from "./menuItem.model";

export class ShoppingCartItem{

    menuItem: MenuItem;
    quantity: number;
    id: number;
    constructor(menuItem: MenuItem, quantity: number = 1){
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    value(){
       return this.menuItem.price * this.quantity;
    }
   
}