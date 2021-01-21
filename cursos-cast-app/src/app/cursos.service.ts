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

  atualizar(curso:Curso):Observable<Curso>{

    return this.http.put<Curso>(`http://localhost:8080/castgroup/cursos/${curso.id}`,curso);
  }

  getCursos() : Observable<Curso[]>{
    return this.http.get<Curso[]>(this.apiURL);

  }

  getCursoById(cursoId : number): Observable<Curso>{
    console.log(`this.apiURL/${cursoId}`);
    return this.http.get<any>(`http://localhost:8080/castgroup/cursos/${cursoId}`);
  }

  deletar(curso:Curso):Observable<any>{

    return this.http.delete<any>(`http://localhost:8080/castgroup/cursos/${curso.id}`);
  }
}
