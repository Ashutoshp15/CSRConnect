import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { about } from '../app/about/about.data';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private stage=new BehaviorSubject('');
  StageMessage = this.stage.asObservable();
  sendSuccessMsg(message: string) {
    this.stage.next(message);
    }
  constructor(private http:HttpClient) {  }
  API_URL = '';
  public getTasks(): Observable<about[]> {
    return this.http.get<about[]>(`${this.API_URL}`);
}
}

