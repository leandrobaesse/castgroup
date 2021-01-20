import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule}from '@angular/forms'


import { CursosRoutingModule } from './cursos-routing.module';
import { CursosFormComponent } from './cursos-form/cursos-form.component';
import { CursosListaComponent } from './cursos-lista/cursos-lista.component';
import{RouterModule} from '@angular/router'

@NgModule({
  declarations: [
    CursosFormComponent, 
    CursosListaComponent
  ],
  imports: [
    CommonModule,
    CursosRoutingModule,
    FormsModule,
    RouterModule
  ],
  exports:[
    CursosFormComponent,
    CursosListaComponent
  ]
})
export class CursosModule { }
