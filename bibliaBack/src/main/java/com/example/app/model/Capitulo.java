package com.example.app.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Capitulo {

	private CapituloData[] data;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	private static class CapituloData{
		private String id;
		private String reference;
		private String number;
	}


}
