package br.com.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.dto.AlunoDto;
import br.com.curso.dto.ProfessorDto;
import br.com.curso.modelos.Aluno;
import br.com.curso.modelos.Aula;
import br.com.curso.modelos.Materia;
import br.com.curso.modelos.Nota;
import br.com.curso.modelos.Professor;
import br.com.curso.services.CadastroService;

@RestController
@RequestMapping(value = "/cadastrar")
public class CadastroController {

	@Autowired
	CadastroService _cadastroService;

	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	public Aluno cadastrarAluno(AlunoDto alunoDto) {

		Aluno aluno = _cadastroService.cadastrarAluno(alunoDto);

		return aluno;
	}

	@RequestMapping(value = "/professor", method = RequestMethod.POST)
	public Professor cadastrarProfessor(ProfessorDto professorDto) {

		Professor professor = _cadastroService.cadastrarProfessor(professorDto);

		return professor;
	}

	@RequestMapping(value = "/materia", method = RequestMethod.POST)
	public Materia cadastrarMateria(Materia materia) {

		Materia novaMateria = _cadastroService.cadastrarMateria(materia);

		return novaMateria;
	}

	@RequestMapping(value = "/aula", method = RequestMethod.POST)
	public Aula cadastrarAula(Aula aula, 
			@RequestParam("idMateria") Integer idMateria,
			@RequestParam("nomeMateria") String nomeMateria) {

		Aula NovaAula = _cadastroService.cadastrarAula(aula, idMateria, nomeMateria);

		return NovaAula;
	}

	@RequestMapping(value = "/nota", method = RequestMethod.POST)
	public Nota cadastrarNota(@RequestParam("idMateria") Integer idMateria,
			@RequestParam("nomeMateria") String nomeMateria, @RequestParam("rgm") String rgm,
			@RequestParam("nota") Float nota) {

		Nota novaNota = _cadastroService.cadastrarNota(idMateria, nomeMateria, rgm, nota);

		return novaNota;
	}

}