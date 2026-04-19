package com.evento.evento.repository;

import org.springframework.data.repository.CrudRepository;

import com.evento.evento.controllers.Convidado;
import java.util.List;
import com.evento.evento.models.Evento;


public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	
	Iterable<Convidado> findByEvento(Evento evento);
	
	 void deleteByEvento(Evento evento);


}
