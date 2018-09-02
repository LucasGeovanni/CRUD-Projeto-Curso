package br.com.curso.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.curso.modelos.Aula;
import br.com.curso.modelos.Pessoa;

public class ProfessorDto extends Pessoa {

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	private String registro;
	private List<Aula> aulas = new ArrayList<>();

	public ProfessorDto() {

	}

	public ProfessorDto(String registro) {
		super();
		this.registro = registro;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

}
