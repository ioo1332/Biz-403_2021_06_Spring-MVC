package com.callor.jdbc.pesistance.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.callor.jdbc.model.UserVO;
import com.callor.jdbc.pesistance.UserDao;
@Repository
public class UserDaoImpV1 implements UserDao{
	
	protected final JdbcTemplate jdbcTemplate;
	
	public UserDaoImpV1(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Override
	public List<UserVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String username) {
		// TODO Auto-generated method stub
		
		String sql=" ";
		Object[]params=new Object[] {username};
		
		UserVO vo=(UserVO)jdbcTemplate.query(sql,params,
				new BeanPropertyRowMapper<UserVO>(UserVO.class));		
		return vo;
		
	}

	@Override
	public int insert(UserVO vo) {
		// TODO Auto-generated method stub
		String sql=" INSERT INTO tbl_member (username,password) ";
		sql+=" VALUES ( ?,? )";
		// JdbcTemplate 으로 query를 전송할때
		// 전달할 값이 몇개 안될때는 object[]배열로 만들지 않아도 된다
		return jdbcTemplate.update(sql,vo.getUsername(),vo.getPassword());
	}

	@Override
	public int update(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String pk) {
		// TODO Auto-generated method stub
		return 0;
	}

}
