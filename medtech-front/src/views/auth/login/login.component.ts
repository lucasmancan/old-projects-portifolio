import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ActivatedRouteSnapshot, Router} from '@angular/router';
import {$EOF} from "codelyzer/angular/styles/chars";
import {ToastrService} from "ngx-toastr";
import { NewPassword } from 'models/newPassword';
import { AuthService } from 'services/auth.service';
import { LoadingService } from 'services/loading.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthService,private loadSvc:LoadingService,  private router: Router, private toastrService: ToastrService, private activatedRoute: ActivatedRoute) {
  }

  public credentials: any = {};
  loading: any = false;
  public step: number = 0;


  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      params => {
        const token = params['auth'];
        if (token) {
          this.verifyAccount(token);
        }
      });
  }


  login() {
    this.loadSvc.start();

    this.authService.signIn(this.credentials).subscribe(res => {
      localStorage.setItem("x-auth", res.headers.get("Authorization"));
      this.router.navigate(["/"])
      this.loadSvc.end();

    }, error => {
      this.loadSvc.end();

      this.toastrService.error( "Verifique suas informações e tente novamente.","Credenciais inválidas")
    })
  }

  verifyEmail($event: any) {
    this.loading = true;
    this.authService.verifyEmail($event).subscribe(res => {
      this.toastrService.success("Enviamos um código de verificação.", "Verifique seu e-mail.")
      this.loadSvc.end();
      this.nextStep();
    }, error => {
      this.loadSvc.end();
    });
  }

  changePassword($event: NewPassword) {
    this.loadSvc.start();


    this.authService.updatePassword($event).subscribe(res => {
      this.toastrService.success("Acesse com sua nova senha", "Senha redefinida.")
      this.step = 0;
      this.loadSvc.end();

    }, error => {
      this.loadSvc.end();
    })
  }

  public verifyAccount(token: string) {
    this.loadSvc.start();

    this.authService.verifyAccount(token).subscribe(res => {
      this.toastrService.success("Sua conta foi ativada", "Bem-vindo à medtech")
      this.loadSvc.end();

    }, error => {
      this.loadSvc.end();
    })
  }

  nextStep() {
    this.step++;
  }
}
