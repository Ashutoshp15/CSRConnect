import { Component, OnInit, HostListener } from "@angular/core";
import { Router } from "@angular/router";
//import { NavigationComponent } from "../shared/header/navigation.component";
import { ApiService } from "../api.service";

declare var $: any;
@Component({
  selector: "app-full-layout",
  templateUrl: "./home_login.component.html",
  styleUrls: ["./home_login.component.scss"],
})
export class HomeLoginComponent implements OnInit {
  Category: string = "company";
  username: string = "";
  password: string = "";
  show: boolean = false;


  constructor(public router: Router, public appService: ApiService) {

  }
  submit() {
    console.log("user name is " + this.username);
    this.clear();
    if (this.Category == "charity") {
      this.appService.sendSuccessMsg("charity");
      this.router.navigate(["/dashboard"]);
    }

    else {
      this.appService.sendSuccessMsg("company");
      this.router.navigate(["/company"]);
    }
  }
  register() {
    this.appService.sendSuccessMsg("login");
    this.router.navigate(["/register"]);

  }
  clear() {
    this.username = "";
    this.password = "";
    this.show = true;
  }

  ngOnInit() {

  }
}


