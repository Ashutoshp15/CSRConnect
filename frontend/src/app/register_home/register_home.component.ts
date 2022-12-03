import { Component, OnInit} from "@angular/core";
import { Router } from "@angular/router";
import { ApiService } from "../api.service";

@Component({
  selector: 'app-register_home',
  templateUrl: './register_home.component.html',
  styleUrls: ['./register_home.component.scss']
})
export class RegisterHomeComponent implements OnInit {
  first: Boolean=false;
  update:Boolean=false;
  username : string ="";
  password : string ="";
  catg:string="";
  email:string="";
  show: boolean= false;
  message:string="";
  constructor(public router:Router,public appService:ApiService) {

  }
     register(){
    console.log("user name is " + this.catg)
    //this.clear();
    this.update=true;
    this.router.navigate(["/about"]);

    }
    clear(){
    this.username ="";
    this.password = "";
    this.show = true;
    }

  ngOnInit(){
    this.appService.StageMessage.subscribe(msg => this.message = msg); 
    if(this.message=="login")
    {
          this.first=true;
          this.update=false;
    }
    else{
      this.update=true;
      this.first=false;
    }
    console.log(" message recieved", this.message);
  }
}



