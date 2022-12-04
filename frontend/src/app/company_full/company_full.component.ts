import { Component, AfterViewInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { about } from '../about.data';
//declare var require: any;

@Component({
  selector: "app-full-layout",
  templateUrl: "./company_full.component.html",
  styleUrls: ["./company_full.component.scss"],
})
export class CompanyFullComponent implements AfterViewInit {
    constructor(public http:HttpClient) {
  }
  detailVar: about[] = [];
  ngOnInit(){
  let headers = new HttpHeaders({
    "Content-Type": "application/json",
    'Access-Control-Allow-Origin': '*',
    "Access-Control-Allow-Methods": "*" ,
     "Access-Control-Allow-Headers":"Content-Type, Accept,Origin, X-Requested-With",
     "access-control-allow-credentials":" true" 
  });
  this.http
    .get<any>('/api/business/totalDonation/Infosys', {
      headers: headers
    })
    .subscribe(data => {
      var tmp=JSON.stringify(data);
     this.detailVar=JSON.parse(tmp);
    //this.searchforDetails(this.detailVar);
    });
}
  ngAfterViewInit() { }
}