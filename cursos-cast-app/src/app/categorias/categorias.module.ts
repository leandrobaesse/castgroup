import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoriasRoutingModule } from './categorias-routing.module';
import { CategoriasFormComponent } from './categorias-form/categorias-form.component';


@NgModule({
  declarations: [
    CategoriasFormComponent
  ],
  imports: [
    CommonModule,
    CategoriasRoutingModule
  ]
})
export class CategoriasModule { }
