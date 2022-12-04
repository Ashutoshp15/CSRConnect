import { Component, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable,BehaviorSubject } from 'rxjs';
import { about } from './about.data';

@Injectable({
  providedIn: 'root'
})
// @Component({

// })
export class ApiService {

  private stage=new BehaviorSubject('');
  StageMessage = this.stage.asObservable();
  sendSuccessMsg(message: string) {
    this.stage.next(message);
    }
    private user=new BehaviorSubject('');
    userMessage = this.user.asObservable();
    sendLoginsuccess(message: string) {
      this.user.next(message);
      }
      username:string="";

    setGlobalVar(currentuser:string) {
      if(currentuser=="")
      {
        console.log("hack applied");
        return;
      }
      this.username = currentuser;
    }
    getGlobalVar():string{
      return this.username;
    }
  constructor(private http:HttpClient) {  }
  API_URL = '';
  public getTasks(): Observable<about[]> {
    return this.http.get<about[]>(`${this.API_URL}`);

}
}
