import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { NewPassword } from 'models/newPassword';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {

  constructor() {
  }

  @Output()
  private onSubmit: any = new EventEmitter<NewPassword>();

  public newPassword: NewPassword = new NewPassword();
  loading: any = false;

  ngOnInit(): void {
  }

  submit() {
    this.onSubmit.emit(this.newPassword)
  }
}
