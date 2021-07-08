package com.callor.gallery.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.gallery.model.MemberVO;
import com.callor.gallery.persistance.ext.MemberDao;
import com.callor.gallery.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service("memberServiceV1")
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImplV1 implements MemberService{

	protected final MemberDao memDao;

	@Autowired
	public void create_member_table(MemberDao dummy) {
		Map<String,String>maps=new HashMap<String,String>();
		memDao.create_table(maps);
	}
	
	/*
	 * 1. 회원가입에서 최초로 가입된 member는 ADMIN 이다
	 * 		회원 테이블에 데이터가 있냐없냐로 판단
	 * 		selectAll()method를 사용하여 최초가입된 member인지 파악
	 * 2. ADMIN 권한을 갖는 최초의 가입자 LEVEL은 0이다
	 * 3. ADMIN이 아닌 일반 가입자는 기본 LEVEL이 9이다
	 * 4. LEVEL이 6보다 큰 맴버는 이미지 보기만 가능하다
	 * 5. 이미지 등록을 하려면 LEVEL이 6보다 작아야한다
	 * 6. 최초 가입한 MEMBER가 가입승인이 되면 LEVEL을 6으로 설정한다
	 * 7. 이미 가입된 맴버의 m_userid정보가 join을 통해서 전달되면 
	 *    회원 정보를 update한다
	 */
	@Override
	public MemberVO join(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
		List<MemberVO>members=memDao.selectAll();
		log.debug("Members{}",members.toString());
		// 아직 member table에 데이터가 하나도 없으면(최초로 가입신청 ADMIN level 0)
		if(members==null||members.size()<1) {
			memberVO.setM_level(0);
		}else {
			// 두번째 회원부터는 레벨 9로 설정
			memberVO.setM_level(9);
		}
		memDao.insertOrUpdate(memberVO);
		return memberVO;
	}

	@Override
	public MemberVO update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findById(String m_userid) {
		// TODO Auto-generated method stub
		
		MemberVO memberVO=memDao.findById(m_userid.trim());
		if(memberVO==null) {
			//가입되지않은 사용자id
			log.debug("가입되지않은 사용자:{}",m_userid);
		}else {
			log.debug("조회된 사용자정보 : {}",memberVO.toString());	
		}
		
		
		return memberVO;
	}

	@Override
	public MemberVO login(MemberVO memberVO, Model model) {
		// TODO Auto-generated method stub
		// 1. memberVO에서 m_userid를 getter한 다음
		// 2. findById를 통해 id조회
		// 3. 만약 결과가 null이면 (가입되지 않은 유저 id)
		// 4. 결과가 null이 아니면
		// 5. 비밀번호 일치 조회
		// 6. 비밀번호 일치 하지않으면 :비밀번호 오류 로그인 거부
		// 7. 비밀번호 일치하면 : 로그인 처리
		
		MemberVO findVO=memDao.findById(memberVO.getM_userid());
		if(findVO==null) {
			model.addAttribute("LOGIN_FAIL", "NOT_USERID");
			return null;
		}
		if(findVO.getM_password().equals(memberVO.getM_password())) {
			return findVO;
		}
			model.addAttribute("LOGIN_FAIL","NEQ_PASS");
		return null;
	}

}
