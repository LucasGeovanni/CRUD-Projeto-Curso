package br.com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.curso.modelos.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

	@Query("select u from Materia u where u.id = :idMateria or u.nome = :nomeMateria")
	Materia buscarMateria(@Param("idMateria") Integer idMateria, @Param("nomeMateria") String nomeMateria);
}
