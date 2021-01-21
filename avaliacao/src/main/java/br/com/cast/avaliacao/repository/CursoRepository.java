package br.com.cast.avaliacao.repository;

import br.com.cast.avaliacao.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("from curso where :data <= dataFim")
    List<Curso> getCursosCadastradosEntreData(LocalDate data);


    List<Curso> findAllByOrderByDataInicioAsc();
}
