package com.example.app.service;


import com.example.app.model.Buscar;
import com.example.app.model.Capitulo;
import com.example.app.model.CapituloCompleto;
import com.example.app.model.Libro;

import com.example.app.model.Version;

public interface IServicio {

	Version getVersiones();
	
	Libro getLibros(String bibleId);
	
	Capitulo getCaps(String bibleId, String bookId);
	
	CapituloCompleto getCapitulo(String bibleId, String chapterId);
	
	Buscar buscar(String bibleId,String query, int limit, int offset);
	
}
