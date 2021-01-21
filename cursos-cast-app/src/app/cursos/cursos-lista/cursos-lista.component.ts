import { Component, OnInit } from '@angular/core';
import { Curso } from '../curso';
import {CursosService} from '../../cursos.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-cursos-lista',
  templateUrl: './cursos-lista.component.html',
  styleUrls: ['./cursos-lista.component.css']
})
export class CursosListaComponent implements OnInit {

  cursos: Curso[] = [];
  cursoSelecionado: Curso;
  mensagemSucesso: string;
  mensagemErro: string;

  constructor(
    private service : CursosService,
    private router : Router) { }

  ngOnInit() {
    this.service.getCursos().subscribe(resposta => this.cursos = resposta);
  }

  novoCadastro(){
    this.router.navigate(['/cursos-form'])
  }

  preparaDelecao(curso: Curso){
    this.cursoSelecionado = curso;
  }

  deletarCurso(){
    this.service.deletar(this.cursoSelecionado)
    .subscribe(response => {
      this.mensagemSucesso = "Curso deletado com sucesso.",
      this.ngOnInit();
    },
    erro => this.mensagemErro = "Erro ao deletar o curso selecionado." 
    )

  }

}
