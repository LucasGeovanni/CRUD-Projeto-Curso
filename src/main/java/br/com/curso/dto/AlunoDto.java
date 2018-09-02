package br.com.curso.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.curso.modelos.Aula;

public class AlunoDto {

	private String rgm;
	private String nome;
	private int idade;
	private String sexo;

	private List<Aula> aulas = new ArrayList<>();

	public AlunoDto() {

	}

	public AlunoDto(String rgm) {
		super();
		this.rgm = rgm;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public String getRgm() {
		return rgm;
	}

	public void setRgm(String rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
