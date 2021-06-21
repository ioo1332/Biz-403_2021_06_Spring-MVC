package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.CompVO;
import com.callor.jdbc.pesistance.CompDao;

import lombok.extern.slf4j.Slf4j;
/*
 * @component
 * 모든 component를 대표하는 annotation
 * 컴파일 과정에서 다소 비용이 많이 소요된다
 * 
 * component annotation
 * @Controller @Service @Repository 이러한 annotation을 사용한다
 * spring container에게 이 표식이 부착된 클래스를 bean으로 생성하여
 * 보관해달라는 지시어
 * 
 * compVo c=new CompVO()
 * object o=new CompVO()
 * 
 * compServiceImplV1 cs= new CompServiceImplV1();
 * compService cs1=new ComplserviceImplV2();
 */
@Slf4j
@Repository("compDaoV1")
public class CompDaoImplV1 implements CompDao{

	protected final JdbcTemplate jdbcTemplate;
	public CompDaoImplV1(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<CompVO> selectAll() {
		// TODO 여기는 출판사 전체 조회
		String sql = " SELECT * FROM tbl_company ";
		
		List<CompVO> compList 
		= jdbcTemplate.query(sql, 
				new BeanPropertyRowMapper<CompVO>(CompVO.class));
		
		log.debug("Comp Select {} ", compList.toString());
		return compList;
	}

	@Override
	public CompVO findById(String cp_code) {

		String sql = "SELECT * FROM tbl_company WHERE cp_code=? ";
		Object[] params = new Object[] { cp_code };
		
		CompVO vo = (CompVO) jdbcTemplate.query(sql, 
				params,
				new BeanPropertyRowMapper<CompVO>(CompVO.class));
		return vo;
	
	}

	@Override
	public int insert(CompVO vo) {

		String sql =  " INSERT INTO tbl_company " ;
		sql += " ( cp_code, cp_title, cp_ceo, cp_addr, cp_tel ) ";
		sql += " VALUES( ?,?,?,?,? ) " ;
		
		Object[] params = new Object[] {
				vo.getCp_code(),
				vo.getCp_title(),
				vo.getCp_ceo(),
				vo.getCp_addr(),
				vo.getCp_tel() 
		};
		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int update(CompVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	/* jdbcTemplate를 사용하여 query를 실행할때
	 * 각 method에서 매개 변수를 받아 query에 전달할텐데
	 * 이때 매개변수는 primitive로 받으면 값을 변환시키는 어려움이 있다
	 * 권장사항으로 매개변수는 wrapper class type으로 설정
	 * 즉 숫자형일경우 int,long대신 Integer Long형으로 선언
	 * 
	 * vo에 담겨서 전달된 값은 Object[]배열로 변환한후 
	 * jdbcTemplate에 전달해주어야한다
	 * 하지만 1~2개정도의 값을 전달할땐 Object배열로 변환후 전달하면
	 * object객체 저장소가 생성되고 메모리를 사용한다
	 * 이때 전달되는 변수가 wrapper class type이면 object배열로 만들지않고
	 * 바로 주입할수있다
	 */
	@Override
	public int delete(String cpcode) {
		// TODO 출판사정보 삭제
		String sql=" DELETE FROM tbl_company";
		sql+=" WHERE cp_code=? ";
		// cpcode가 String wrapper class type이므로 
		// object[]배열로 변환하지 않고 바로 전달이 가능하다
		// Object[] params=new Object[] { cpcode };
		jdbcTemplate.update(sql,cpcode);
		return 0;
	}
	
	/* 출판사 이름으로 검색하기 */
	@Override
	public List<CompVO> findByCName(String cname) {
		// TODO Auto-generated method stub
		String sql=" SELECT *FROM tbl_company ";
		//WHERE cp_code LIKE '%'||'%'// ORACLE
		sql+=" WHERE cp_name LIKE CONCAT('%',? '%')";
		// select를 수행한후 각각의 데이터를 CompVO에 담고
		// List 에 add하여 return 한후 compList에 받기 
		List<CompVO>compList=jdbcTemplate.query(sql, new Object[] {cname},
				new BeanPropertyRowMapper<CompVO>(CompVO.class));
		
		return compList;
	}

	@Override
	public List<CompVO> findByTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompVO> findByCeo(String ceo) {
		// TODO Auto-generated method stub
		return null;
	}
	/* tbl_company table 에서 cpcode(출판사코드)중 
	 * 가장 큰 값을 추출하기
	 */
	@Override
	public String findByMaxCode() {
		String sql=" SELECT MAX(cp_code) FROM tbl_company ";
		
		String cpcode=(String)jdbcTemplate.queryForObject(sql, String.class);

		return cpcode;
	}

}
