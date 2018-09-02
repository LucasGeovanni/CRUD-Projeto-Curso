package br.com.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.dto.AlunoDto;
import br.com.curso.modelos.Aula;
import br.com.curso.services.AulaService;

@RestController
@RequestMapping(value = "/aula")
public class AulaController {
	@Autowired
	private AulaService _aulaService;

	@RequestMapping(value = "/aluno", method = RequestMethod.GET)
	public AlunoDto buscarAulaAulo(@RequestParam("rgm") String rgm) {

		AlunoDto alunoDto = _aulaService.buscarAluno(rgm);

		return alunoDto;
	}

	@RequestMapping(value = "/aluno/grade", method = RequestMethod.GET)
	public List<Aula> montarGradeAluno(@RequestParam("rgm") String rgm) {

		List<Aula> aula = _aulaService.montarGradeAluno(rgm);

		return aula;
	}

	@RequestMapping(value = "/professor/grade", method = RequestMethod.GET)
	public List<Aula> montarGradeProfessor(@RequestParam("registro") String registro) {

		List<Aula> aula = _aulaService.montarGradeProfessor(registro);

		return aula;
	}

}
