package com.example.app.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Libro {
	
	private LibroData[] data;
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	private static class LibroData{
		private String id;
		private String name;
		private String abbreviation;
	}
}
