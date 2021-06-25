package com.callor.score.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SubjectAndScoreDTO {
	
	private String ss_code;// as ss_code,
	private String ss_stname;// as ss_stname,
	private String ss_prof;// as ss_prof,
	private String ss_stnum;// as ss_stnum,
	private int ss_score;// as ss_score as ss_code

}
