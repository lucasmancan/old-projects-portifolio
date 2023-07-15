import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AuthService} from 'services/auth.service';
import { LoadingService } from 'services/loading.service';

@Component({
  selector: 'user-cmp',
  moduleId: module.id,
  templateUrl: 'user.component.html'
})

export class UserComponent implements OnInit {
  constructor(private activateRoute: ActivatedRoute, private service: AuthService, private loadingSvc: LoadingService) {
  }

  public user: any = {};

  ngOnInit(): void {
    this.load()
  }


  private load() {
    this.loadingSvc.start();
    this.service.current().subscribe(res => {
      this.user = res
      this.loadingSvc.end();

    })
  }


  update() {
    this.loadingSvc.start();

    this.service.update(this.user).subscribe(res => {
      this.user = res;
      this.loadingSvc.end();
    });
  }
}
