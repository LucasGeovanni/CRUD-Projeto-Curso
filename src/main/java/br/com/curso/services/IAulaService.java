package br.com.curso.services;

import java.util.List;

import br.com.curso.dto.AlunoDto;
import br.com.curso.dto.ProfessorDto;
import br.com.curso.modelos.Aluno;
import br.com.curso.modelos.Aula;

public interface IAulaService {
	
	public AlunoDto buscarAluno(String rgm);

	public Aluno buscarAlunoOriginal(String rgm);

	public ProfessorDto buscarProfessor(Integer id);

	public List<Aula> montarGradeAluno(String rgm);

	public List<Aula> montarGradeProfessor(String registro);

}
