import { Component, OnInit, HostListener } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-full-layout",
  templateUrl:  "./home_login.component.html",
  styleUrls: ["./home_login.component.scss"],
})
export class HomeLoginComponent implements OnInit {
  subtitle: string;
  username : string ="";
  password : string ="";
  show: boolean= false;
  constructor(public router:Router) {
    this.subtitle = 'This is some text within a card block.';
  }
     submit(){
    console.log("user name is " + this.username)
    this.clear();
    this.router.navigate(["/dashboard"]);
    }
    clear(){
    this.username ="";
    this.password = "";
    this.show = true;
    }

  ngOnInit(){
    
  }
}


