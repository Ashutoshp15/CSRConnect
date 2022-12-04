import { Component, AfterViewInit, EventEmitter, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
import { ApiService } from './../../api.service';

declare var $: any;

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  //styleUrls: ['..../assets/scss/core/theme-colors/_theme-colors.scss']
})
export class NavigationComponent implements AfterViewInit {
  @Output() toggleSidebar = new EventEmitter<void>();
  public config: PerfectScrollbarConfigInterface = {};

  public showSearch = false;

  constructor(private modalService: NgbModal,public appService:ApiService) {
    
  }
     catg:string="";
     showCatg:boolean=true;
     showcom:boolean=true;
     username:string="Smile Foundation";
    // username:string="Infosys"
  
  ngOnInit(){
    //this.appService.userMessage.subscribe(user => this.username = user);
    console.log("user",this.username);
    this.appService.sendLoginsuccess(this.username);
   this.appService.StageMessage.subscribe(msg => this.catg = msg); 
    if(this.catg=='charity'||this.username=="Smile Foundation"){
      console.log("charity",this.catg);
      this.showCatg=true;
      this.showcom=false;
    }
    else
   if(this.catg=='company'||this.username=="Infosys"){
      console.log("company",this.catg);
      this.showCatg=false;
      this.showcom=true;
    }
   }
   ngAfterViewInit(): void {
    this.appService.StageMessage.subscribe(msg => this.catg = msg); 
    if(this.catg=='charity'){
      console.log("charity",this.catg);
      this.showCatg=true;
      this.showcom=false;
    }
    else
   if(this.catg=='company'){
      console.log("company",this.catg);
      this.showCatg=false;
      this.showcom=true;
    }
     
   }
   // This is for Notifications
  notifications: Object[] = [
    {
      btn: 'btn-danger',
      icon: 'ti-link',
      title: 'Luanch Admin',
      subject: 'Just see the my new admin!',
      time: '9:30 AM'
    },
    {
      btn: 'btn-success',
      icon: 'ti-calendar',
      title: 'Event today',
      subject: 'Just a reminder that you have event',
      time: '9:10 AM'
    },
    {
      btn: 'btn-info',
      icon: 'ti-settings',
      title: 'Settings',
      subject: 'You can customize this template as you want',
      time: '9:08 AM'
    },
    {
      btn: 'btn-warning',
      icon: 'ti-user',
      title: 'Pavan kumar',
      subject: 'Just see the my admin!',
      time: '9:00 AM'
    }
  ];

  // This is for Mymessages
  mymessages: Object[] = [
    {
      useravatar: 'assets/images/users/user1.jpg',
      status: 'online',
      from: 'Pavan kumar',
      subject: 'Just see the my admin!',
      time: '9:30 AM'
    },
    {
      useravatar: 'assets/images/users/user2.jpg',
      status: 'busy',
      from: 'Sonu Nigam',
      subject: 'I have sung a song! See you at',
      time: '9:10 AM'
    },
    {
      useravatar: 'assets/images/users/user2.jpg',
      status: 'away',
      from: 'Arijit Sinh',
      subject: 'I am a singer!',
      time: '9:08 AM'
    },
    {
      useravatar: 'assets/images/users/user4.jpg',
      status: 'offline',
      from: 'Pavan kumar',
      subject: 'Just see the my admin!',
      time: '9:00 AM'
    }
  ];

  public selectedLanguage: any = {
    language: 'English',
    code: 'en',
    type: 'US',
    icon: 'us'
  }

  public languages: any[] = [{
    language: 'English',
    code: 'en',
    type: 'US',
    icon: 'us'
  },
  {
    language: 'Español',
    code: 'es',
    icon: 'es'
  },
  {
    language: 'Français',
    code: 'fr',
    icon: 'fr'
  },
  {
    language: 'German',
    code: 'de',
    icon: 'de'
  }]

}

