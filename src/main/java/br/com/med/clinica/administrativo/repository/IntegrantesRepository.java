package br.com.med.clinica.administrativo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.med.clinica.administrativo.model.Integrantes;

@Repository
public interface IntegrantesRepository extends CrudRepository<Integrantes, Long> {

	List<Integrantes> findAll();
}
