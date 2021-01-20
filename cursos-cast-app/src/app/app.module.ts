import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import{HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import{TemplateModule } from './template/template.module';
import { HomeComponent } from './home/home.component';

import{CursosModule} from './cursos/cursos.module';

import{CategoriasService} from  './categorias.service';

import{CursosService} from  './cursos.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TemplateModule,
    CursosModule
  ],
  providers: [
    CategoriasService,
    CursosService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
