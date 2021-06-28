package com.callor.score.dao.ext;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.callor.score.dao.GenericDao;
import com.callor.score.model.ScoreDTO;
import com.callor.score.model.ScoreVO;
import com.callor.score.model.SubjectAndScoreDTO;

public interface ScoreDao extends GenericDao<ScoreVO, Long>{
	
	public List<ScoreDTO>selectViewAll();
	public List<ScoreDTO>findByStNum(String st_num);
	
	public List<SubjectAndScoreDTO> selectSubjectAndScore(String stNum);
	/*	mybatis에서 SQL select의 결과가 숫자일경우 
	 * result type으로 wrapper class를 지정한다
	 * int : Integer,  long: :Long
	 * 문자열일 경우 result Type 으로 string을 반드시 지정한다
	 * string:String
	 * 
	 * Dao method의 return type도 wrapper class type으로 지정
	 */
	public Integer scoreCount(String st_num);
	public Integer scoreSum(String st_num);
	//#{st_num},#{sc_sbcode},#{sc_score}
	public Integer insertOrUpdate(
		@Param("st_num") String sc_num,
		@Param("sc_sbcode")	String sc_sbcode,
		@Param("sc_score")	String sc_score);
	
	public Integer insertOrUpdateForList(@Param("st_num")String stNum,@Param("scoreMaps")List<Map<String,String>>scoreMaps);
	
}
