import {Injectable} from '@angular/core';
import {AppService} from './app.service';
import {Router} from '@angular/router';
import {$e} from "codelyzer/angular/styles/chars";
import {NewPassword} from "../models/newPassword";

@Injectable()
export class AuthService {

  constructor(private appService: AppService, private router: Router) {
  }

  public getToken(): string {
    return localStorage.getItem('x-auth');
  }

  public signIn(credentials: any) {
    // @ts-ignore
    return this.appService.post('/auth', credentials, {observe: 'response'})
  }

  public signUp(user: any) {
    return this.appService.post('/users/signup', user)
  }

  public verifyAccount(token: any) {
    return this.appService.get(`/users/verify-account/${token}`)
  }

  public verifyEmail(email: string) {
    return this.appService.get(`/users/verify-email/${email}`)
  }

  public update(data: any) {
    return this.appService.put(`/users/`, data)
  }

  public current() {
    return this.appService.get(`/users/current`)
  }

  public isAuthenticated(): boolean {
    return this.getToken() !== null;
  }

  updatePassword(password: NewPassword) {
    return this.appService.post(`/users/reset-password/`, password)
  }

}
