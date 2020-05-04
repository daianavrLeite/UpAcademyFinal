import { Injectable } from '@angular/core';
import { of, Observable } from 'rxjs';
import { DataInteraction } from '../models/dataInteration';
import { HttpHeaders, HttpClient, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';


var httpOptions = { headers: new HttpHeaders({ "Content-Type": "application/json" }) }

@Injectable({
  providedIn: 'root'
})
export class DataService {
  obs: DataInteraction[] = [];

  apiUrl = 'http://127.0.0.1:8080/kpiManager/api/';
  

  constructor(private http: HttpClient) {

  }
 

 public getAllData():Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl + 'interactions/all');
  }

  public getAllWeeks():Observable<any> {
    return this.http.get<any>(this.apiUrl + 'interactions/allWeeks')
    .pipe(
      map(weeks => {
        return weeks.sort((a, b) => {return a-b});
      })
    );
  }

  public getAllClients():Observable<any> {
    return this.http.get<any>(this.apiUrl + 'interactions/allClients');
  }

  public getAllBManagers():Observable<any> {
    return this.http.get<any>(this.apiUrl + 'interactions/allBManagers');
  }

  public getAllInteractions():Observable<any> {
    return this.http.get<any>(this.apiUrl + 'interactions/allInteractions');
  }

 public getAllUnities():Observable<any> {
   return this.http.get<any>(this.apiUrl + 'interactions/allUnits');
 }

 public getAllRevenueClient():Observable<any> {
  
  return this.http.get<any>(this.apiUrl + 'interactions/filter/client');
  // ,  {
  //   params
  // });
}

public getAllRevenueManager():Observable<any> {
  return this.http.get<any>(this.apiUrl + 'interactions/filter/manager');
}

// interactions/revenue/manager?id=2&interaction=Contrato
// interactions/revenue/client?id=1&interaction=Contrato
// params = params.append('name', myselectWeek);
// params = params.append('interaction', myselectUnit);
 }
