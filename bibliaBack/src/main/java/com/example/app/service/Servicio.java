package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.app.model.Buscar;
import com.example.app.model.Capitulo;
import com.example.app.model.CapituloCompleto;
import com.example.app.model.Endpoints;
import com.example.app.model.Libro;
import com.example.app.model.Version;


@Service
public class Servicio implements IServicio{

	@Autowired
	private RestTemplate rt;
	@Value("${bible.api.key}")
	private String key;
	@Value("${api.base}")
	private String base;

	public HttpHeaders prepHdr() {
		HttpHeaders hdr=new HttpHeaders();
		hdr.set("api-key", key);
		return hdr;
	}

	@Override
	public Version getVersiones() {
		String url= base+Endpoints.GET_VERSIONES;
		HttpEntity<Void> ent= new HttpEntity<Void>(prepHdr());
		try {
			return rt.exchange(url, HttpMethod.GET, ent, Version.class).getBody();
		}catch(HttpClientErrorException ex){
			System.err.println("API error: "+ex.getStatusCode());
			return null;
		}catch(Exception e) {
			System.err.println("Error: "+e.getMessage());
			return null;
		}
	}

	@Override
	public Libro getLibros(String bibleId) {
		String ep=String.format(Endpoints.GET_LIBROS, bibleId);
		String url=base+ep;
		HttpEntity<Libro> ent= new HttpEntity<Libro>(prepHdr());

		try {
			return rt.exchange(url, HttpMethod.GET, ent, Libro.class).getBody();
		}catch(HttpClientErrorException ex){
			System.err.println("API error: "+ex.getStatusCode());
			return null;
		}catch(Exception e) {
			System.err.println("Error: "+e.getMessage());
			return null;
		}
	}

	@Override
	public Capitulo getCaps(String bibleId, String bookId) {
		String ep=String.format(Endpoints.GET_CAPS, bibleId, bookId);
		String url=base+ep;
		HttpEntity<Capitulo> ent= new HttpEntity<Capitulo>(prepHdr());
		try {
			return rt.exchange(url, HttpMethod.GET, ent, Capitulo.class).getBody();
		}catch(HttpClientErrorException ex){
			System.err.println("API error: "+ex.getStatusCode());
			return null;
		}catch(Exception e) {
			System.err.println("Error: "+e.getMessage());
			return null;
		}
	}

	@Override
	public CapituloCompleto getCapitulo(String bibleId, String chapterId) {
		String ep=String.format(Endpoints.GET_CAPCOMPLE, bibleId, chapterId);
		String url=base+ep;
		HttpEntity<CapituloCompleto> ent= new HttpEntity<CapituloCompleto>(prepHdr());
		try {
			return rt.exchange(url, HttpMethod.GET, ent, CapituloCompleto.class).getBody();
		}catch(HttpClientErrorException ex){
			System.err.println("API error: "+ex.getStatusCode());
			return null;
		}catch(Exception e) {
			System.err.println("Error: "+e.getMessage());
			return null;
		}
	}

	@Override
	public Buscar buscar(String bibleId, String query, int limit, int offset) {
		String ep=String.format(Endpoints.BUSCAR, bibleId);
		String url1=base+ep;
		UriComponentsBuilder ucb= UriComponentsBuilder.fromUriString(url1).queryParam("query", query).queryParam("limit", limit).queryParam("offset", offset);
		String url= ucb.toUriString();
		HttpEntity<Buscar> ent= new HttpEntity<Buscar>(prepHdr());
		try {
			return rt.exchange(url, HttpMethod.GET, ent, Buscar.class).getBody();
		}catch(HttpClientErrorException ex){
			System.err.println("API error: "+ex.getStatusCode());
			return null;
		}catch(Exception e) {
			System.err.println("Error: "+e.getMessage());
			return null;
		}
	}

}
