import { Component, OnInit } from '@angular/core';
import { CategoriasService } from '../../categorias.service';
import { Categoria } from '../../categorias/categoria';
import { Curso } from '../curso';
import { CategoriaIdInput } from '../categoriaIdInput';
import{CursosService} from '../../cursos.service';
import {Router,ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-cursos-form',
  templateUrl: './cursos-form.component.html',
  styleUrls: ['./cursos-form.component.css']
})
export class CursosFormComponent implements OnInit {


  categorias: Categoria[]
  curso: Curso;
  categoriaId: CategoriaIdInput;

  success: boolean = false;
  errors: String[]= [];

  id: number;


  constructor(
    private categoriaService:CategoriasService,
    private service:CursosService,
    private router : Router,
    private activatedRoute : ActivatedRoute
  ) { 
    this.curso = new Curso;
    this.categoriaId = new CategoriaIdInput;
    this.curso.categoria = this.categoriaId;
  }

  ngOnInit(): void {
    this.categoriaService
    .getCategorias()
    .subscribe(response => this.categorias = response);

    const idParam = this.activatedRoute.snapshot.paramMap.get('id');

    if(idParam){
      this.id = parseInt(idParam);

      this.service.getCursoById(this.id)
                  .subscribe(response => this.curso = response,
                              errorResponse => this.curso = new Curso()
        );
    }
  }
  
  onSubmit(){

    if(this.id){
      this.service
      .atualizar(this.curso)
      .subscribe(response => {
          this.success = true;
          this.errors = null;
      }, errorResponse =>{
          this.success = false;
          if(errorResponse.error.objects == null){
            this.errors = [];
            this.errors.push(errorResponse.error.userMessage);
            console.log(this.errors);
          }else{
            this.errors = errorResponse.error.objects;
          }    
      } )

    }else{

      this.service
      .salvar(this.curso)
      .subscribe(response => {
          this.success = true;
          this.errors = null;
          this.curso = new Curso;
          this.categoriaId = new CategoriaIdInput;
          this.curso.categoria = this.categoriaId;
      }, errorResponse =>{       
          this.success = false;
          if(errorResponse.error.objects == null){
            this.errors = [];
            this.errors.push(errorResponse.error.userMessage);
            console.log(this.errors);
          }else{
            this.errors = errorResponse.error.objects;
          }
             
      } )

    }
 
  }


  voltarParaListagem(){
    this.router.navigate(['/cursos-lista'])
  }
}
