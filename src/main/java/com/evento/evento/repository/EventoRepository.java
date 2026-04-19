package com.evento.evento.repository;

import org.springframework.data.repository.CrudRepository;

import com.evento.evento.models.Evento;

public interface EventoRepository extends CrudRepository<Evento,Long>{
	
	Evento findByCodigo(long codigo);

}
