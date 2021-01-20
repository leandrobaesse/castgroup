import { Component, OnInit } from '@angular/core';
import { CategoriasService } from '../../categorias.service';
import { Categoria } from '../../categorias/categoria';
import { Curso } from '../curso';
import { CategoriaIdInput } from '../categoriaIdInput';
import{CursosService} from '../../cursos.service';

@Component({
  selector: 'app-cursos-form',
  templateUrl: './cursos-form.component.html',
  styleUrls: ['./cursos-form.component.css']
})
export class CursosFormComponent implements OnInit {


  categorias: Categoria[]
  curso: Curso;
  categoriaId: CategoriaIdInput;

  constructor(
    private categoriaService:CategoriasService,
    private service:CursosService
  ) { 
    this.curso = new Curso;
    this.categoriaId = new CategoriaIdInput;
    this.curso.categoria = this.categoriaId;
  }

  ngOnInit(): void {
    this.categoriaService
    .getCategorias()
    .subscribe(response => this.categorias = response);
  }
  
  onSubmit(){
    this.service.salvar(this.curso).subscribe(response => {
      console.log(response);
    })
  }

}
