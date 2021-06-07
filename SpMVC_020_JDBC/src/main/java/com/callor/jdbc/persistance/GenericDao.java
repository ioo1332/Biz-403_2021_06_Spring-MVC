package com.callor.jdbc.persistance;

import java.util.List;

import com.callor.jdbc.model.BookVO;
/*
 * 제네릭 
 * 인터페이스의 부모역할을 하는 super interface
 * dao와 같은 인터페이스를 설계할때 table마다 dao 인터페이스를 만들고
 * 인터페이스를 상속받아 클래스를 선언하는데 이때 대부분의 dao에는 같은이름의
 * method가 존재하더라 
 * 
 * 그런데 method들이 return 타입과 매개변수가 달라서 어쩔수없이 비슷한,거의 같은 method를 갖는 인터페이스를 중복작성 해야 하더라
 * 
 * 제네릭(<>)을 interface에 설정하고 임의의 이름을 지정해줌
 * 여기서는 vo pk라는 이름을 임의로 지정하였다
 * 그리고 method를 선언할때 제네릭으로 지정된 이름을 사용하여 return타입과 공통 매개변수를 사용하였다
 * 이렇게 generic을 담는 interface를 만들어두고 또 다른 interface를 만들때
 * 이 generic을 상속받아 사요한다
 * 
 * 상속받는 interface는 상속되는 곳에 자신의 vo,primary칼럼의 pk type을 지정해주면 공통된 메서드를
 * 다시 만들 필요가 없어진다
 * 
 * List<String>
 * List<BookVO>
 *  
 */
public interface GenericDao<VO,PK> {
	
	public List<VO> selectAll();
	public VO findByID(PK pk);
	public int insert(VO vO);
	public int update(VO vO);
	public int delete(PK pk);

}
