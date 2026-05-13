package com.example.app.model;

public final class Endpoints {

	private Endpoints() {}
	
	public static final String GET_VERSIONES= "/bibles";
	public static final String GET_LIBROS= "/bibles/%s/books";
	public static final String GET_CAPS= "/bibles/%s/books/%s/chapters";
	public static final String GET_CAPCOMPLE= "/bibles/%s/chapters/%s";
	public static final String GET_VERSO= "/bibles/%s/verses/%s";
	public static final String BUSCAR= "/bibles/%s/search";
}
