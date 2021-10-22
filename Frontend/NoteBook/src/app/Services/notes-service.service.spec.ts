import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';

import { NoteSimilarity } from '../models/NoteSimilarity';
import { NotesService } from './notes-service.service';
import { NoteSimilarityResponse } from '../models/NoteSimilarityResponse';
import { environment } from 'src/environments/environment';


//Testing of EmployeeService
describe('NotesServiceService.frequencyAndSimiliarity()', () => {
  let httpClient: HttpClient;
  let httpTestingController: HttpTestingController;
  let noteService: NotesService;

  beforeEach(() => {
    //Configures testing app module
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [
        NotesService
      ]
    });

    //Instantaites HttpClient, HttpTestingController and EmployeeService
    httpClient = TestBed.inject(HttpClient);
    httpTestingController = TestBed.inject(HttpTestingController);
    noteService = TestBed.inject(NotesService);
  });

  afterEach(() => {
    httpTestingController.verify(); //Verifies that no requests are outstanding.
  });
  
  //Test case 1
  it('should check similarity and frequency of word and return the data', () => {
    const note: NoteSimilarity = { content: "Word Words Wor word", word: "Word"
  };
    const Result:NoteSimilarityResponse={
      "word": "Word",
      "frequencyCount": 3,
      "similarWords": [
          "word"
      ]
  }
    noteService.frequencyAndSimiliarity(note).subscribe();
    let req = httpTestingController.expectOne({ method: "POST", url: environment.apiUrl+"/similarity/check" });
   
    expect(req.request.body).toEqual(note);
  



  //Test case 2
  // it('should turn 404 error into return of the requested employee', () => {
  //   const newEmp: Employee = { name: 'Mahesh', age: 25 };

  //   empService.addEmployee(newEmp).subscribe(
  //     data => expect(data).toEqual(newEmp, 'should return the employee'),
  //     fail
  //   );

  //   const req = httpTestingController.expectOne(empService.empUrl);

  //   // respond with a 404 and the error message in the body
  //   const msg = '404 error';
  //   req.flush(msg, { status: 404, statusText: 'Not Found' });
  // });
}); 


// let httpClientSpy: { get: jasmine.Spy };


// beforeEach(() => {
//   // TODO: spy on other methods too
//   httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
//   noteService = new NotesService(httpClientSpy as any);
// });

})
// it('should return expected heroes (HttpClient called once)', (done: DoneFn) => {
//   const expectedHeroes: NoteSimilarityResponse =
//   {
//     "word": "Word",
//     "frequencyCount": 3,
//     "similarWords": [
//         "word"
//     ]
// }

//   httpClientSpy.get.and.returnValue(asyncData(expectedHeroes));

//   noteService.frequencyAndSimiliarity().subscribe(
//     heroes => {
//       expect(heroes).toEqual(expectedHeroes, 'expected heroes');
//       done();
//     },
//     done.fail
//   );
//   expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');
// });

// it('should return an error when the server returns a 404', (done: DoneFn) => {
//   const errorResponse = new HttpErrorResponse({
//     error: 'test 404 error',
//     status: 404, statusText: 'Not Found'
//   });

//   httpClientSpy.get.and.returnValue(asyncError(errorResponse));

//   noteService.getHeroes().subscribe(
//     heroes => done.fail('expected an error, not heroes'),
//     error  => {
//       expect(error.message).toContain('test 404 error');
//       done();
//     }
//   );
// });

// function asyncData(expectedHeroes: NoteSimilarityResponse): any {
//   throw new Error('Function not implemented.');
// }
