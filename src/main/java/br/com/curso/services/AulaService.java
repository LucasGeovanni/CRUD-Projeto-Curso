package br.com.curso.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.dto.AlunoDto;
import br.com.curso.dto.ProfessorDto;
import br.com.curso.modelos.Aluno;
import br.com.curso.modelos.Aula;
import br.com.curso.modelos.Professor;
import br.com.curso.repositories.AlunoRepository;
import br.com.curso.repositories.AulaRepository;
import br.com.curso.repositories.ProfessorRepository;

@Service
public class AulaService {

	@Autowired
	private AlunoRepository _alunosRepository;

	@Autowired
	private ProfessorRepository _professorRepository;

	@Autowired
	private AulaRepository _aulaRepository;

	public AlunoDto buscarAluno(String rgm) {

		Aluno aluno = _alunosRepository.buscarAluno(rgm);

		AlunoDto alunoDto = new AlunoDto(aluno.getRgm());

		return alunoDto;
	}
	
	public Aluno buscarAlunoOriginal(String rgm) {

		Aluno aluno = _alunosRepository.buscarAluno(rgm);

		return aluno;
	}
	

	public ProfessorDto buscarProfessor(Integer id) {
		Optional<Professor> professor = _professorRepository.findById(id);

		ProfessorDto professorDto = new ProfessorDto(professor.get().getRegistro());

		return professorDto;
	}

	public List<Aula> montarGradeAluno(String rgm) {		
		
		List<Aula> aula = _aulaRepository.montarGradeAluno(rgm);

		return aula;
	}
	
	public List<Aula> montarGradeProfessor(String registro) {		
		
		List<Aula> aula = _aulaRepository.montarGradeProfessor(registro);

		return aula;
	}

}
