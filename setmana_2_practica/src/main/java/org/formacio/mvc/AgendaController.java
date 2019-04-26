package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
}
