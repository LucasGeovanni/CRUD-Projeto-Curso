package br.com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.curso.modelos.Aluno;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

	@Query("select u from Aluno u where u.rgm = :rgm")
	Aluno buscarAluno(@Param("rgm") String rgm);
}
