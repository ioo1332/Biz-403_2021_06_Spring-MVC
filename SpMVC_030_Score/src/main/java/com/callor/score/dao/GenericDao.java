package com.callor.score.dao;

import java.util.List;

/* Generic interface
 * 아직 매개변수 , return type이 정해지지않은 인터페이스
 * 같은 기능의 method를 갖는 인터페이스를 설계할때 
 * 복사 붙이기등을 하지않고 공통된 method를 쉽게 구현하기 위하여
 * 표준 parent형 인터페이스를 만든것
 */
public interface GenericDao<VO, PK> {
	
	public List<VO> selectAll();
	public VO findById(PK VO);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);

}
