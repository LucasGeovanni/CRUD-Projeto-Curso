package br.com.curso.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.dto.AlunoDto;
import br.com.curso.dto.ProfessorDto;
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

@Service
public class CadastroService implements ICadastroService {

	@Autowired
	private AlunoRepository _alunosRepository;

	@Autowired
	private ProfessorRepository _professorRepository;

	@Autowired
	private AulaRepository _aulaRepository;

	@Autowired
	private MateriaRepository _materiaRepository;

	@Autowired
	private NotaRepository _notaRepository;

	@Autowired
	public AulaService _aulaService;

	public Aluno cadastrarAluno(AlunoDto alunoDto) {

		Aluno aluno = fromAlunoDto(alunoDto);

		return _alunosRepository.save(aluno);
	}

	public Professor cadastrarProfessor(ProfessorDto professorDto) {

		Professor professor = fromProfessorDto(professorDto);

		return _professorRepository.save(professor);
	}

	public Aula cadastrarAula(Aula aula, Integer idMateria, String nomeMateria) {

		Materia materia = _materiaRepository.buscarMateria(idMateria, nomeMateria);

		Aula novaAula = new Aula();
		novaAula.setDiaSemana(aula.getDiaSemana());
		novaAula.setSala(aula.getSala());
		novaAula.getMateria().add(materia);

		return _aulaRepository.save(novaAula);
	}

	public Materia cadastrarMateria(Materia materia) {

		Materia novaMateria = _materiaRepository.save(materia);

		return novaMateria;
	}

	public Nota cadastrarNota(Integer idMateria, String nomeMateria, String rgm, Float valorNota) {
		Aluno aluno = _aulaService.buscarAlunoOriginal(rgm);

		Nota nota = new Nota();
		nota.setValor(valorNota);
		nota.getAlunos().addAll(Arrays.asList(aluno));

		Materia materia = _materiaRepository.buscarMateria(idMateria, nomeMateria);
		((Materia) materia).getNota().addAll(Arrays.asList(nota));

		_notaRepository.save(nota);
		_materiaRepository.save(materia);

		return nota;
	}

	public Professor fromProfessorDto(ProfessorDto professorDto) {
		Professor professor = new Professor();
		professor.setRegistro(professorDto.getRegistro());
		professor.getAulas().add((Aula) Arrays.asList(professorDto.getAulas()));
		professor.setNome(professorDto.getNome());
		professor.setIdade(professorDto.getIdade());
		professor.setSexo(professorDto.getSexo());

		return professor;
	}

	public Aluno fromAlunoDto(AlunoDto alunoDto) {
		Aluno aluno = new Aluno();
		aluno.setRgm(alunoDto.getRgm());
		aluno.getAulas().add((Aula) Arrays.asList(alunoDto.getAulas()));
		aluno.setNome(alunoDto.getNome());
		aluno.setIdade(alunoDto.getIdade());
		aluno.setSexo(alunoDto.getSexo());

		return aluno;
	}

}
