import { Component, OnInit } from '@angular/core';
import {blogcard,blogcards} from './blog-cards-data';

@Component({
  selector: 'app-blog-cards',
  templateUrl: './blog-cards.component.html'
})
export class BlogCardsComponent implements OnInit {

  blogcards:blogcard[];
  val:string='';

  constructor() { 

    this.blogcards=blogcards;
  }
redirect(){

}
  ngOnInit(): void {
  }

}
