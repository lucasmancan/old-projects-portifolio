import {Injectable} from '@angular/core';
import {Observable, Subject} from 'rxjs';

@Injectable({providedIn: 'root'})
export class SearchService {
  private subject = new Subject<any>();

  sendMessage(message: string, reset: boolean) {
    this.subject.next({text: message, reset: true});
  }

  clearMessages() {
    this.subject.next();
  }

  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }
}
