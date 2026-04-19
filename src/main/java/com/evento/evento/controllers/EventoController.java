package com.evento.evento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.evento.evento.models.Evento;
import com.evento.evento.repository.ConvidadoRepository;
import com.evento.evento.repository.EventoRepository;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EventoController {
	
	@Autowired
	private EventoRepository er;
	
	@Autowired
	private ConvidadoRepository cr;
	
	@RequestMapping(value="/cadastrarEvento",method=RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
		
	}
		@RequestMapping(value="/cadastrarEvento",method=RequestMethod.POST)
		public String form(Evento evento) {
			
		er.save(evento);
			return "redirect:/cadastrarEvento";
		
	}
		
	@RequestMapping("/eventos")	
	public ModelAndView listaEventos() {
	    ModelAndView mv = new ModelAndView("evento/index");
	    List<Evento> eventos = (List<Evento>) er.findAll();
	    mv.addObject("eventos", eventos);
	    return mv;
	}
	

	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEventos(@PathVariable("codigo") long codigo) {
	    Evento evento = er.findByCodigo(codigo);
	    ModelAndView mv = new ModelAndView("evento/detalhesEventos");
	    mv.addObject("evento", evento);

	    List<Convidado> convidados = (List<Convidado>) cr.findByEvento(evento); // ← cast para List
	    mv.addObject("convidados", convidados);

	    return mv;
	}
	
   @Transactional
	@RequestMapping(value="/{codigo}/deletar", method=RequestMethod.POST)
	public String deletarEvento(@PathVariable("codigo") long codigo) {
	    Evento evento = er.findByCodigo(codigo);
	    cr.deleteByEvento(evento); // deleta convidados primeiro
	    er.delete(evento);
	    return "redirect:/eventos";
	}
   
   @Transactional
   @RequestMapping(value="/{codigo}/convidados/{rg}/deletar", method=RequestMethod.POST)
   public String deletarConvidado(@PathVariable("codigo") long codigo,
                                   @PathVariable("rg") String rg) {
       cr.deleteById(rg);
       return "redirect:/{codigo}";
   }
	
	@RequestMapping(value="/{codigo}",method=RequestMethod.POST)
	public String detalhesEventos(@PathVariable("codigo") long codigo,Convidado convidado) {
		Evento evento = er.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);
		return "redirect:/{codigo}";
	}

}
