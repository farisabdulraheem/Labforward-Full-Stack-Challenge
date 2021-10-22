import { Component, OnInit } from '@angular/core';
import { NoteSimilarity } from 'src/app/models/NoteSimilarity';
import { NoteSimilarityResponse } from 'src/app/models/NoteSimilarityResponse';
import { NotesService } from 'src/app/Services/notes-service.service';
declare var $: any;
@Component({
  selector: 'app-text-editor',
  templateUrl: './text-editor.component.html',
  styleUrls: ['./text-editor.component.css']
})
export class TextEditorComponent implements OnInit {
  error:Boolean=false;
  selectedWord: string = "";
  content: string = "";
  show: Boolean = false;
  result: string = "";
  resultFrequency: number = 0;
  resultSimilarWords: string[] = [];
  notes: NoteSimilarity | undefined;
  notesResponse: NoteSimilarityResponse | undefined;


  constructor(private service: NotesService) { }

  ngOnInit(): void {
    $('.toast').toast('show');
  }
  
  highlight(event: MouseEvent) {
    this.show = false;
    if (window.getSelection) {
      this.selectedWord = window.getSelection()!.toString().trim();;
    } 
    else if (typeof document.getSelection != "undefined") {
      this.selectedWord = document.getSelection()!.toString().trim();;
    }

    this.getfrequencyAndSimiliarity(this.content, this.selectedWord);

  }

  getfrequencyAndSimiliarity(content: string, word: string) {
    if (content && word) {
      this.notes = { "content": content, "word": word };

      this.service
        .frequencyAndSimiliarity(this.notes)
        .subscribe(result => {
         
          if(result.frequencyCount){
            this.show = true;
            this.resultFrequency = result.frequencyCount;
          }
          else{
            this.show = false;
          }
          if(result.similarWords){
            this.resultSimilarWords = result.similarWords;
          }
      
      
         
        })
    }

  }

}
