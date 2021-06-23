package com.callor.score.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScoreVO {
	
	private Long sc_seq;//	bigint
	private String sc_stnum;//	char(8)
	private String sc_sbcode;//	varchar(20)
	private int sc_score;//	int


}
