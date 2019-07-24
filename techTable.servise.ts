import { Injectable }              from '@angular/core';
import { HttpHeaders, HttpResponse }   from '@angular/common/http';
import { HttpClient } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { TechTable } from './techTable';
import { TechTableDet } from './techTableDet';
import { stringify } from 'querystring';
import { LoginService } from '../authentication/login/login.service';




@Injectable({ providedIn: 'root' })
export class TechTableService {
  
  public servicioUrl = 'http://localhost:8080/techsoft';  // URL to web API
  public techTable: TechTable;
  public techTableDet: TechTableDet ;
  public  errorMessage: string;
  constructor (private http: HttpClient,private serviceAut:LoginService) {}
 

  public getListTable(): Observable<TechTable[]> {

    const token = this.serviceAut.currentUserValue.access_token;
    const httpOptions= {
      headers: new HttpHeaders(
        { 'Content-Type': 'application/json' ,
          'Authorization': `Bearer ${token}`
        })
      };
    return this.http.get<TechTable[]>(this.servicioUrl+"/TechTableTable/listar/01",  httpOptions).pipe(
                catchError(this.handleError('getListTable',[]))
            );
    }
    public getList(): Observable<TechTable[]> {
      const token = this.serviceAut.currentUserValue.access_token;
    const httpOptions= {
      headers: new HttpHeaders(
        { 'Content-Type': 'application/json' ,
          'Authorization': `Bearer ${token}`
        })
      };
      return this.http.get<TechTable[]>(this.servicioUrl+"/TechTableTable/listarTable",  httpOptions).pipe(
                  catchError(this.handleError('getListTable',[]))
              );
      }
	
    public getInsertarTable(techTable:TechTable): Observable<any> {
      const token = this.serviceAut.currentUserValue.access_token;
    const httpOptions= {
      headers: new HttpHeaders(
        { 'Content-Type': 'application/json' ,
          'Authorization': `Bearer ${token}`
        })
      };
    
        return this.http.post<any>(this.servicioUrl+"/TechTable/insertarTable/", techTable, httpOptions).pipe(map(data => {
          if (data) {
              if (data.codigo === '1') {
                  return true;
              }
          }
          return false;
          }) );
      }

      public getActualizarTable(techTable:TechTable): Observable<any> {
        const token = this.serviceAut.currentUserValue.access_token;
    const httpOptions= {
      headers: new HttpHeaders(
        { 'Content-Type': 'application/json' ,
          'Authorization': `Bearer ${token}`
        })
      };
        return this.http.put<any>(this.servicioUrl+"/TechTable/actualizarTable/", techTable, httpOptions).pipe(map(data => {
          if (data) {
              if (data.codigo === '1') {
                  return true;
              }
          }
          return false;
          }) );
      }
      
      public getTableforId(tableId): Observable<TechTable> {
        const token = this.serviceAut.currentUserValue.access_token;
    const httpOptions= {
      headers: new HttpHeaders(
        { 'Content-Type': 'application/json' ,
          'Authorization': `Bearer ${token}`
        })
      };
        return this.http.get<TechTable>(this.servicioUrl+"/TechTable/"+tableId,httpOptions).pipe(
          catchError(this.handleError<TechTable>('getTableforId'))
         )
    }

    public getListTableDet(tableId): Observable<TechTableDet[]> {
      const token = this.serviceAut.currentUserValue.access_token;
    const httpOptions= {
      headers: new HttpHeaders(
        { 'Content-Type': 'application/json' ,
          'Authorization': `Bearer ${token}`
        })
      };
      return this.http.get<TechTableDet[]>(this.servicioUrl+"/TableTableDet/listar/"+tableId,  httpOptions).pipe(
                  catchError(this.handleError('getListTable',[]))
              );
      }
    
      public getPRUEBASA(){}

    private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
 

}
