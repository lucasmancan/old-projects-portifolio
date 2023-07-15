import { Injectable } from '@angular/core';
import { ReplaySubject } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';

@Injectable()
export class LoadingService {

    constructor(private spinner: NgxSpinnerService) {
    }

    start() {
        this.spinner.show();
    }

    end() {
        setInterval( () => this.spinner.hide() , 300)
    }
}
