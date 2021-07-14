package com.callor.gallery.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GalleryFilesDTO {
	/*
	 *  tbl_gallery 와 tbl_files table을 join하여 select한 데이터는 실제로는 1:n관걔로 생성된 결과이다
	 *  
	 *  하지만 실제 보여지는 list는 마치 tbl_gallery가 여러개 있는거처럼 보인다
	 *  
	 *  gallery 1개 데이터에 file이 3개 첨부된경우 보여지는 list
	 *  =====================
	 *  1번 gallery   1번파일
	 *  1번 gallery   2번파일
	 *  1번 gallery   3번파일
	 *  =====================
	 *  실제로 gallery는 1개이지만 추출된 데이터는 전체가 list이므로
	 *  전체 view를 담을 DTO를 선언하고 list<DTO>형 변수에 데이터를 담았다
	 *  
	 *  실제 데이터와 상관없이 g.seq등등 gallery정보를 담을 변수들은 
	 *  1개만 있으면 될것을 files갯수만큼 강제로 생성하는 결과가 된다
	 *  
	 */
	// 갤러리정보
	private Long g_seq;//	bigint
	private String g_writer;//	varchar(125)
	private String g_date;//	varchar(10)
	private String g_time;//	varchar(10)
	private String g_subject;//	varchar(50)
	private String g_content;//	varchar(1000)
	private String g_image;//	varchar(256)
	// 파일정보
	private Long f_seq;//	bigint
	private String f_original;//	varchar(256)
	private String f_upname;//	varchar(256)
	

}
