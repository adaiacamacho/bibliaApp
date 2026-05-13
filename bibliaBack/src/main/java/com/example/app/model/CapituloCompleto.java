package com.example.app.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CapituloCompleto {

	private CapCompletoData data;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	private static class CapCompletoData{
		private String id;
		private String number;
		private String reference;
		private int verseCount;
		private String content;
		private Next next;
		private Previous previous;


		@Data
		@AllArgsConstructor
		@NoArgsConstructor
		@Builder
		private static class Next{
			private String id;
			private String number;
		}
		@Data
		@AllArgsConstructor
		@NoArgsConstructor
		@Builder
		private static class Previous{
			private String id;
			private String number;
		}
	}


}
