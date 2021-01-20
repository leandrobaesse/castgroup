import { Injectable } from '@angular/core';
import{Categoria} from './categorias/categoria';
import { HttpClient } from '@angular/common/http';
import {observable, Observable} from 'rxjs'
import{environment} from '../environments/environment'


@Injectable({
  providedIn: 'root'
})
export class CategoriasService {

  apiURL:string = environment.apiURL + '/castgroup/categorias';

  constructor(private http: HttpClient) { }

  getCategorias(): Observable<Categoria[]>{
    return this.http.get<Categoria[]>(`${this.apiURL}`);
  }
}
