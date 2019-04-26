package org.formacio.repositori;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class AgendaService {

	private Map<String, Persona> bbdd = new LinkedHashMap<>();
	
	@PostConstruct
	public void init() {
		bbdd.put("ant", new Persona("ant","Antoni","971-555123"));
		bbdd.put("joa", new Persona("joa","Joana","971-555555"));
		bbdd.put("lin", new Persona("lin","Lina","971-555888"));
	}
	
	public void inserta (String id, String nom, String telefono) {
		bbdd.put(id, new Persona(id, nom, telefono));
	}
	
	public String telefono (String telefono) {
		return bbdd.get(telefono).toString();
	}
	
	public Persona recupera (String id) {
		return bbdd.get(id);
	}
	
	public int nombreContactes() {
		return bbdd.size();
	}
}
