import { Component, AfterViewInit } from '@angular/core';
//declare var require: any;

@Component({
  selector: "app-full-layout",
  templateUrl: "./company_full.component.html",
  styleUrls: ["./company_full.component.scss"],
})
export class CompanyFullComponent implements AfterViewInit {
  subtitle: string;
  constructor() {
    this.subtitle = 'This is some text within a card block.';
  }

  ngAfterViewInit() { }
}