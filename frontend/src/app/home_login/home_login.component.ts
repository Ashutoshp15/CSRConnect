import { Component, OnInit, HostListener } from "@angular/core";
import { Router } from "@angular/router";
//import { NavigationComponent } from "../shared/header/navigation.component";
import { ApiService } from "../api.service";
import {login} from "../about.data";

declare var $: any;
@Component({
 // providers:[ApiService],
  selector: "app-full-layout",
  templateUrl: "./home_login.component.html",
  styleUrls: ["./home_login.component.scss"],
})
export class HomeLoginComponent {
  Category: string = "company";
  username: string = "";
  password: string = "";
  show: boolean = false;
  error:boolean=false;


  constructor(public router: Router, public appService: ApiService) {
    console.log("home login constructor");
  }
  submit() {
    console.log("user name is " + this.username);
    this.appService.setGlobalVar(this.username);
    this.appService.sendLoginsuccess(this.username);
    
    if(this.username=="Smile Foundation" ||this.username=="Rapid response"){
      this.Category="charity";
      this.show=true;
      console.log("Login Success for Charity");
    }else
    if(this.username=="Infosys" ||this.username=="Barclays"){
      this.Category="company";
      this.show=true;
      console.log("Login Success for Business");
    }
    else{
      this.error=true;
    }
    if (this.Category == "charity" && this.show==true) {
      this.appService.sendSuccessMsg("charity");
      this.router.navigate(["/dashboard"]);
    }
  

    else {
      if(this.show==true){
      this.appService.sendSuccessMsg("company");
      this.router.navigate(["/company"]);
    }
  }
  //this.clear();
  }
  register() {
    this.appService.sendSuccessMsg("login");
    this.router.navigate(["/register"]);

  }
  clear() {
    this.username = "";
    this.password = "";
    this.error=false;
   
  }

  ngOnInit() {

  }
}


