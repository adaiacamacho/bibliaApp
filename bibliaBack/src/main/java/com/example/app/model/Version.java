package com.example.app.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Version {

	private VersionData[] data;
	
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	private static class VersionData{
		private String id;
		private String name;
		private String abbreviation;
	}
	
}
