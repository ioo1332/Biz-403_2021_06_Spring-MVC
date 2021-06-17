<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<style>
	form#join_form{
		width: 350px;
		padding: 40px;
		margin:50px auto;
		
		background-color: black;
		text-align: center;
		border-radius: 20px;
	}
	form#join_form h2{
		color: white;
		font-weight: 500;
	}
	form#join_form input{
		outline: 0;
		display: block;
		
		width:200px;
		margin: 20px auto;
		
		padding:14px 10px;
		
		color:white;
		
		background: none;
		border: 2px solid #3498db;
		border-radius: 25px;
		
		text-align: center;
		transition:0.3s;
	}
	form#join_form input:focus{
		width: 250px;
		border-color: #2ecc71;
	}
	form#join_form button{
		
		outline: none; /*none 이나 0*/
		display: block;
		
		background: none;
		
		width: 200px;
		margin: 20px auto;
		padding:14px 10px;
		
		text-align: center;
		border: 1px solid #2ecc71;
		color: white;
		border-radius: 25px;
		cursor: pointer;
		
	}
	forrm#join_form button:hover{
		background-color: #2ecc71;
		
	}

</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<section class="main_sec">
	<form id="join_form" method="post">
		<h2>회원가입</h2>
		<input name="m_username" placeholder="사용자 ID">
		<input type="password" name="m_password" placeholder="사용자 비밀번호">
		<input type="password" name="m_re_password" placeholder="사용자 비밀번호 확인">
		<button class="btn_insert">가입신청</button>
	</form>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>

</body>
<script>
document.querySelector("button.btn_insert")
	.addEventListener("click",()=>{
		location.href = "${rootPath}/books/insert";
});
</script>

</html>