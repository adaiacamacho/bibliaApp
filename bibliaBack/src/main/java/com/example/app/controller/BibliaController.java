package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Buscar;
import com.example.app.model.Capitulo;
import com.example.app.model.CapituloCompleto;
import com.example.app.model.Libro;
import com.example.app.model.Version;
import com.example.app.service.IServicio;

@CrossOrigin(origins="*")
@RestController
public class BibliaController {
	
	@Autowired
	private IServicio service;
	
	@Value("${bibleId}")
	private String idRV;
	
	
	@GetMapping("/")
	public String test() {
		return "hola";
	}
	@GetMapping("/versiones")
	public Version getVersiones() {
		return service.getVersiones();
	}

	@GetMapping("/libros") 
	public Libro getLibros(@RequestParam(defaultValue="${bibleId}") String bibleId) {
		return service.getLibros(bibleId);
	}
	
	@GetMapping("/capitulos") 
	public Capitulo getCaps(@RequestParam(defaultValue="${bibleId}") String bibleId, @RequestParam(defaultValue="GEN") String bookId) {
		return service.getCaps(bibleId, bookId);
	}
	
	
	@GetMapping("/fullcap") 
	public CapituloCompleto getCapCompleto(@RequestParam(defaultValue="${bibleId}") String bibleId, @RequestParam(defaultValue="GEN.1") String chapterId) {
		return service.getCapitulo(bibleId, chapterId);
	}	
	
	
	@GetMapping("/buscar")
	public Buscar buscar(@RequestParam(defaultValue="${bibleId}") String bibleId, @RequestParam String query, @RequestParam(defaultValue="10") int limit, @RequestParam(defaultValue="0") int offset) {
		return service.buscar(bibleId, query, limit, offset);
	}
}
