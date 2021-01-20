import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CursosFormComponent} from './cursos-form/cursos-form.component';
import { CursosListaComponent } from './cursos-lista/cursos-lista.component';

const routes: Routes = [
  {path: 'cursos-form' , component:CursosFormComponent},
  {path:'cursos-lista', component:CursosListaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CursosRoutingModule { }
