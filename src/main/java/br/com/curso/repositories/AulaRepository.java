package br.com.curso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.curso.modelos.Aula;

public interface AulaRepository extends JpaRepository<Aula, Integer> {

	@Query(value = "Select a.id as id, a.sala as sala, a.dia_semana, m.nome as materia "
			+ " from aula a inner join aula_materia am on am.aula_id = a.id "
			+ " inner join materia m on am.materia_id = m.id inner join aluno_aulas aa on a.id = aa.aulas_id "
			+ " inner join aluno al on aa.aluno_id = al.id where al.rgm = :rgm", nativeQuery = true)
	List<Aula> montarGradeAluno(@Param("rgm") String rgm);

	@Query(value = "Select a.id as id, a.sala as sala, a.dia_semana, m.nome as materia "
			+ "from aula a inner join aula_materia am on am.aula_id = a.id"
			+ " inner join materia m on am.materia_id = m.id inner join professor_aulas pa on a.id = pa.aulas_id"
			+ " inner join professor p on pa.professor_id = p.id where p.registro = :registro", nativeQuery = true)
	List<Aula> montarGradeProfessor(@Param("registro") String registro);

}
