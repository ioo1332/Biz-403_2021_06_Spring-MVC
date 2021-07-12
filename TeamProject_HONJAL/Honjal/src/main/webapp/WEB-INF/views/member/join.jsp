<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<form id="join_form">
      <h2 class="board_title">회원 가입</h2>
      <fieldset>
        <div>
          <label>아이디</label>
          <input type="text" id="member_id" placeholder="6자 이상 영문과 숫자 조합"/>
          <button id="btn_id_check">중복확인</button>
        </div>
        <div>
          <label>비밀번호</label>
          <input type="password" id="member_password" placeholder="8자 이상 영문과 숫자 조합"/>
        </div>
        <div>
          <label>비밀번호 재입력</label>
          <input type="password" id="member_password2" placeholder="재입력 해주세요"/>
        </div>
        <div>
          <label>이름</label>
          <input type="text" id="member_name" />
        </div>
        <div>
          <label>닉네임</label>
          <input type="text" id="member_nickname" />
        </div>
        <div>
          <label>e-mail</label>
          <input type="email" id="member_email" />
        </div>
      </fieldset>
      
      <section id="join_btn">
        <button type="submit">회원가입</button>
        <button>취소</button>
      </section>
</form>

<script>
let member_id = document.querySelector("#member_id")
let msg_member_id = document.querySelector("div.member.id")
let id_check = document.querySelector("#btn_id_check")
if(member_id){
	id_check.addEventListener("click",(e)=>{
		member_id.addEventListener("blur",(e)=>{
			let memberid = e.currentTarget.value
			msg_member_id.innerText = ""
			msg_member_id.style.padding="0"
			
			if(member_id === ""){
				msg_member_id.innerText = " * 아이디는 반드시 입력하세요"
				msg_member_id.style.padding = "5px"
				msg_member_id.style.color="red"
				member_id.focus()
				return false
			}else if(member_id < 6){
				msg_member_id.innerText = " * 아이디는 6자 이상 입력하세요"
				msg_member_id.style.padding = "5px"
				msg_member_id.style.color="red"
				member_id.focus()
				return false
			}
			fetch("${rootPath}/member/id_check?member_id="+member_id)
			.then(response=>response.text())
			.then(result=>{
				if(result === "USE_ID"){
					msg_member_id.innerText = " * 이미 가입된 ID 입니다"
					msg_member_id.style.color="red"
					member_id.focus()
					return false
				}else if(result === "NOT_USE_ID"){
					msg_member_id.innerText = " * 가입 가능한 ID 입니다"
					msg_member_id.style.color="blue"
					document.querySelector("#member_password").focus()
				}
			})
		})
	})
}
</script>