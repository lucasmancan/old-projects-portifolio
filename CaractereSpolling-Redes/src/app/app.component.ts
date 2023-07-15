import { Component } from '@angular/core';
import { NonNullAssert } from '@angular/compiler';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CaractereSpolling';
  private _numero: string;
  public numeroFinal: any = '';
  public erro: any = false;

  set numero(newNumero: string) {
    if(this.numero == null){ 
      this._numero = ''
      this.numeroFinal = ''
    };

    if (newNumero.toString().charAt(newNumero.toString().length - 1) === "1" || newNumero.toString().charAt(newNumero.toString().length - 1) === "0") {
      this.erro = false;
      this._numero = newNumero;
      if (this.numeroFinal.toString().length >= 5 && this.numeroFinal.toString().slice(this.numeroFinal.length - 5, this.numeroFinal.length) === "11111") {
        this.numeroFinal += "0";
        this.numeroFinal += newNumero.toString().charAt(newNumero.toString().length - 1);
      } else {
        this.numeroFinal += newNumero.toString().charAt(newNumero.toString().length - 1);
      }
    } else {
      this.erro = true;
      this.numeroFinal='';
      this._numero ='';
    }
  }

  get numero() {
    return this._numero;
  }

  public apagarCampo(event) {
    if (event.keyCode === 8) {
      this._numero = ''
      this.numeroFinal = '';
      this.erro = false;
    }
  }


}
