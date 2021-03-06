<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<style>
	div.msg.view{
		color:yellow;
		background-color: red;
		font-size: 20px;
		padding: 2rem;
		border-radius: 20px;
	}
	div#login_box{
		background-color:lime;
		border: 1px solid black;
		margin:30px auto;
		text-align: center;
		width: 50%;
	}
	label{
		
		
	}
	
</style>
<form method="POST" id="login_form">
<div id="login_box">
	<div class="msg login error">
	
	</div>
	<div>
		<label>사용자ID</label>
		<input name="m_userid" type="email">
	</div>
	<div>
		<label>비밀번호</label>
		<input name="m_password" type="password">
	</div>
	<div>
		<button type="button" class="login">로그인</button>
		<button type="button" class="join">회원가입</button>
	</div>
	</div>
</form>
<script>
let form=document.querySelector("#login_form")
let btn_login=document.querySelector("button.login")
let btn_join=document.querySelector("button.join")
let msg_error=document.querySelector("div.msg.login.error")

let input_userid=document.querySelector("input[name='m_userid']")
let input_password=document.querySelector("input[name='m_password']")
if(btn_login){
	btn_login.addEventListener("click",()=>{
		let m_userid=input_userid.value
		let m_password=input_password.value
		
		if(m_userid===""){
			alert("사용자 id는 필수 입력 항목 입니다")
			input_userid.focus()
			return false
		}
		if(m_password===""){
			alert("사용자 password는 필수 입력 항목 입니다")
			input_password.focus()
			return false
		}
		form.submit()
	})
}
if(btn_join){
	btn_join.addEventListener("click",()=>{
		location.href="${rootPath}/member/join"
	})
}

let login_fail="${LOGIN_FAIL}"
if(login_fail==="NOT_USERID"){
	msg_error.innerText="사용자 id가 없습니다"
	msg_error.classList.add("view")
	//msg_error.style.fontsize="20px"
	//msg_error.style.backgroundColor="red"
	//msg_error.style.padding="2rem"
}else if(login_fail==="NEQ_PASS"){
	msg_error.innerText="비밀번호가 틀렸습니다"
	msg_error.classList.add("view")
	//msg_error.style.fontsize="20px"
	//msg_error.style.backgroundColor="red"
	//msg_error.style.padding="2rem"
}else if(login_fail==="LOGIN_REQ"){
	msg_error.innerHTML="로그인이 필요한 서비스입니다<br/>"
	msg_error.innerHTML+="로그인 해주세요"
	msg_error.classList.add("view")
	
}
	

</script>