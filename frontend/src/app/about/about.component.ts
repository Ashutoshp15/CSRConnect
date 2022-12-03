import { Component, } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { tap } from 'rxjs/operators';
// @Injectable({
//   providedIn: 'root'
//})
@Component({
  templateUrl: './about.component.html'
})
export class AboutComponent {
  private url="'https://app.swaggerhub.com/apis/VATSALPRAFULBHAIBHAN/CSRConnect/1.0.0#/default/get_charities'";
  constructor(private http:HttpClient) {

  }
	title = 'api-angular';
	ngOnInit() {
		// API Call

		let headers = new HttpHeaders({
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin': '*',
      "Access-Control-Allow-Methods": "*" ,
       "Access-Control-Allow-Headers":"Content-Type, Accept,Origin, X-Requested-With",
       "access-control-allow-credentials":" true" 
		});
		this.http
			.get<any>('/api/get_charities', {
				headers: headers
			})
			.subscribe(data => {
				console.log(data);
			});
	}
}
