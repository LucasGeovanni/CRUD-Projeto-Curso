package br.com.curso;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.curso.modelos.Aluno;
import br.com.curso.modelos.Aula;
import br.com.curso.modelos.Materia;
import br.com.curso.modelos.Nota;
import br.com.curso.modelos.Professor;
import br.com.curso.repositories.AlunoRepository;
import br.com.curso.repositories.AulaRepository;
import br.com.curso.repositories.MateriaRepository;
import br.com.curso.repositories.NotaRepository;
import br.com.curso.repositories.ProfessorRepository;

@SpringBootApplication
public class CursoApplication implements CommandLineRunner {

	@Autowired
	private ProfessorRepository _professorRepository;

	@Autowired
	private MateriaRepository _materiaRepository;

	@Autowired
	private NotaRepository _notaRepository;

	@Autowired
	private AlunoRepository _alunoRepository;

	@Autowired
	AulaRepository _aulaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Nota nota = new Nota(0f);
		Nota nota1 = new Nota(0f);

		Materia materia = new Materia("POO");
		materia.getNota().addAll(Arrays.asList(nota));
		Materia materia1 = new Materia("TDA");
		materia1.getNota().addAll(Arrays.asList(nota));
		Materia materia2 = new Materia("PW");
		materia2.getNota().addAll(Arrays.asList(nota));
		Materia materia3 = new Materia("ES");
		materia3.getNota().addAll(Arrays.asList(nota));

		Aula aula = new Aula("305B", "Segunda");
		aula.getMateria().addAll(Arrays.asList(materia));
		Aula aula1 = new Aula("405B", "Terça");
		aula1.getMateria().addAll(Arrays.asList(materia1));
		Aula aula2 = new Aula("405B", "Quarta");
		aula2.getMateria().addAll(Arrays.asList(materia2));

		Professor professor = new Professor("9999");
		professor.getAulas().addAll(Arrays.asList(aula, aula1));
		Professor professor1 = new Professor("8888");
		professor1.getAulas().addAll(Arrays.asList(aula, aula2));

		Aluno aluno = new Aluno("16951484");
		aluno.getAulas().addAll(Arrays.asList(aula, aula1));
		Aluno aluno1 = new Aluno("16951485");
		aluno1.getAulas().addAll(Arrays.asList(aula1, aula2));
		
		_notaRepository.saveAll(Arrays.asList(nota, nota1));
		_materiaRepository.saveAll(Arrays.asList(materia, materia1, materia2));
		_aulaRepository.saveAll(Arrays.asList(aula, aula1, aula2));
		_professorRepository.saveAll(Arrays.asList(professor, professor1));
		_alunoRepository.saveAll(Arrays.asList(aluno, aluno1));

	}
}
