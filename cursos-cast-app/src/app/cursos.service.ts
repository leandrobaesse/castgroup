import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {observable, Observable} from 'rxjs'
import{Curso} from './cursos/curso';
import{environment} from '../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class CursosService {

  apiURL:string = environment.apiURL + '/castgroup/cursos';

  constructor(private http: HttpClient) { }

  salvar(curso:Curso):Observable<Curso>{

    return this.http.post<Curso>(this.apiURL,curso);
  }
}
