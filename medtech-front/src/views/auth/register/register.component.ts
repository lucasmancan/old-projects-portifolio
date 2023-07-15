import {Component, OnInit} from '@angular/core';
import {Route, Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import { AuthService } from 'services/auth.service';
import { LoadingService } from 'services/loading.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  signupform: any = {};
  loading: any = false;

  constructor(private authService: AuthService,private loadSvc:LoadingService,  private router: Router, private toastrService: ToastrService) {
  }

  ngOnInit(): void {
  }

  signup() {
    this.loadSvc.start();
    this.authService.signUp(this.signupform).subscribe(res => {
      this.toastrService.success("Verificação pendente", "Acesse seu e-mail para ativar sua conta");

      this.router.navigate(["/auth/entrar"]);
      this.loadSvc.end();


    }, error => {
      this.loadSvc.end();
    })
  }
}
