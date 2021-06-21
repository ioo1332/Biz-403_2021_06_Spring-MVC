package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.AuthorVO;
import com.callor.jdbc.pesistance.AuthorDao;
@Repository("authorDaoV1")
public class AuthorDaoImplV1 implements AuthorDao{
	/*
	 * 일반적인 spring Framework에서 다른 bean연결하기
	 * @Autowired는 이미 bean으로 생성되어 spring container에 보관중인
	 * 객체를 여기에 주입해달라
	 * 
	 * @inject 
	 * Java에서 기본적으로 제공하는 DI(Dependency Inject)를 수행하는 Annotation
	 * 일부에서 @inject를 사용하자라는 말이 있지만
	 * Spring Framework를 사용할때는 굳이 그러지 말자
	 */
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<AuthorVO> selectAll() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tbl_author";
		List<AuthorVO>authorList=jdbcTemplate.query(sql, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		return authorList;
	}

	@Override
	public AuthorVO findById(String au_code) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tbl_author";
		sql+=" WHERE cp_code=?";
		AuthorVO author=(AuthorVO)jdbcTemplate.query(sql,new Object[] {au_code}, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		return author;
		
	}

	@Override
	public int insert(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AuthorVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AuthorVO> findByAName(String aname) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tbl_author";
		sql += " WHERE cp_title LIKE CONCAT('%', ? , '%') ";
		
		List<AuthorVO> authorList=jdbcTemplate.query(sql,new Object[] {aname}, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		return authorList;
	}

	@Override
	public List<AuthorVO> findByATel(String atel) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tbl_author";
		sql+=" WhERE cp_tel=?";
		/* 전화번호로 조회를 하면 1개의 데이터만 추출될것이다 하지만 db조회ㅎ에서 pk를 기준으로 조회하느것은
		 * 모두 list 타입으로
		 */
		 
		List<AuthorVO> authorList=jdbcTemplate.query(sql,new Object[] {atel}, new BeanPropertyRowMapper<AuthorVO>(AuthorVO.class));
		return authorList;
	}

}
