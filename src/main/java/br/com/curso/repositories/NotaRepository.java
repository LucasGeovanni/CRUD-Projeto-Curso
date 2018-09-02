package br.com.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso.modelos.Nota;
@Repository
public interface NotaRepository extends JpaRepository<Nota, Integer> {

}
