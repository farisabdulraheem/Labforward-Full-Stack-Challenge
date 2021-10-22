import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { NoteSimilarity } from '../models/NoteSimilarity';
import { catchError, Observable, of, retry } from 'rxjs';
import { NoteSimilarityResponse } from '../models/NoteSimilarityResponse';
import { environment } from 'src/environments/environment';


const endpoint = environment.apiUrl;
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',

  })
};
@Injectable({
  providedIn: 'root'
})
export class NotesService {

  constructor(private httpClient: HttpClient) { }


  frequencyAndSimiliarity(data: any): Observable<NoteSimilarityResponse> {
    return this.httpClient.post<NoteSimilarity>(endpoint + '/similarity/check', data, httpOptions)
    .pipe(
      retry(1),
      catchError(this.handleError('frequencyAndSimiliarity', data))
    )
  }  

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
       alert("Please check The api connection")
      return of(result as T);
    };
  }
  private log(message: string) {
    console.log(message);
  }
  
}
