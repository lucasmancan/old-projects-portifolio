import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-verify-email',
  templateUrl: './verify-email.component.html',
  styleUrls: ['./verify-email.component.css']
})
export class VerifyEmailComponent implements OnInit {
  email: any;
  loading: any = false;

  @Output()
  private onSubmit: EventEmitter<string> = new EventEmitter<string>();

  @Output()
  private onSkip: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor() {
  }

  ngOnInit(): void {
  }

  submit() {
    this.onSubmit.emit(this.email)
  }

  skip() {
    this.onSkip.emit(true);
  }
}
