package br.com.curso.services;

import br.com.curso.dto.AlunoDto;
import br.com.curso.dto.ProfessorDto;
import br.com.curso.modelos.Aluno;
import br.com.curso.modelos.Aula;
import br.com.curso.modelos.Materia;
import br.com.curso.modelos.Nota;
import br.com.curso.modelos.Professor;

public interface ICadastroService {

	public Aluno cadastrarAluno(AlunoDto alunoDto);

	public Professor cadastrarProfessor(ProfessorDto professorDto);

	public Aula cadastrarAula(Aula aula, Integer idMateria, String nomeMateria);

	public Materia cadastrarMateria(Materia materia);

	public Nota cadastrarNota(Integer idMateria, String nomeMateria, String rgm, Float valorNota);

	public Professor fromProfessorDto(ProfessorDto professorDto);

	public Aluno fromAlunoDto(AlunoDto alunoDto);
}
