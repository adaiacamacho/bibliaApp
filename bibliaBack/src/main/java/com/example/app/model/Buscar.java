package com.example.app.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Buscar {
	
	private BuscarData data;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	private static class BuscarData{
		private String query;
		private int limit;
		private int offset;
		private int total;
		private Verso[] verses;
		
		@Data
		@AllArgsConstructor
		@NoArgsConstructor
		@Builder
		private static class Verso{
			private String id;
			private String reference;
			private String text;
		}
	}
}
