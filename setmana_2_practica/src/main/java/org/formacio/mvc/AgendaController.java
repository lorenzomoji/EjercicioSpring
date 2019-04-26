package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AgendaController {

	@Autowired
	private AgendaService agenda;
	
	@RequestMapping(path = "numero")
	@ResponseBody
	public int numero () {
		return agenda.nombreContactes();
	}
	
	@RequestMapping(path = "/telefono")
	@ResponseBody
	public String telefono(String id) {
		return agenda.recupera(id).getTelefon();
	}
	
	@RequestMapping(path = "/contacto/{id}")
	@ResponseBody
	public Persona contacto(@PathVariable String id) {
		return agenda.recupera(id);
	}
	
	@RequestMapping(path = "/contacto/{id}", produces = {MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Persona contactoCoustomizado(@PathVariable String id) {
		return agenda.recupera(id);
	}
	
	@ExceptionHandler()
	@ResponseBody
	public String error(ArithmeticException e) {
		return "Ha habido un error";
	}
}


