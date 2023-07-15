import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Pageable} from "../../models/pageable.model";

@Component({
  selector: 'app-paginator',
  templateUrl: './app-paginator.component.html',
  styleUrls: ['./app-paginator.component.css']
})
export class AppPaginatorComponent implements OnInit {

  @Input()
  public paginator: Pageable;

  @Output() onPaginate = new EventEmitter();


  public

  constructor() {
  }

  ngOnInit(): void {
  }

  paginate(i: number) {
    this.paginator.number = i;
    this.onPaginate.emit(this.paginator)
  }

  counter(totalPages: any) {
    return new Array(totalPages);
  }
}
