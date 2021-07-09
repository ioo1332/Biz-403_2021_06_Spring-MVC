package com.callor.gallery.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDTO {

	private Long file_seq;//	BIGINT	AUTO_INCREMENT	PRIMARYKEY
	private Long file_gseq;//	BIGINT	NOT NULL	
	private String file_original;//	VARCHAR(125)	NOT NULL	
	private String file_upname;//	VARCHAR(125)	NOT NULL	
	
	

}
