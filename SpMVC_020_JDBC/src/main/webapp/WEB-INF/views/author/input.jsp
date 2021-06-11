<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />    
    
<!DOCTYPE html>
<html>

<meta charset="UTF-8">

<title>나의 홈페이지</title>
<style>
form {
	width: 80%;
	margin: 15px auto;
}

fieldset {
	border: 1px solid green;
	border-radius: 15px;
}

legend {
	text-align: center;
	padding: 10px 20px;
	background-color: #aaa;
}

form div {
	width: 80%;
	margin: 5px auto;
}

form label {
	display: inline-block;
	width: 20%;
	text-align: right;
	margin: 8px 5px;
	padding: 8px;
	color: rgba(0, 0, 255, 0.5);
	font-weight: bold;
}

form input {
	width: 70%;
	margin: 4px 5px;
	padding: 8px 20px;;
	border-radius: 25px;
	outline: 0;
	border-color: rgba(0, 255, 0, 0.5);
}

form input:focus {
	border-color: #999;
}

form input:hover {
	background-color: #ddd;
}
</style>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<body>
<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<h1>저자 정보 등록</h1>
	<form method="POST">
	<fieldset>
	<legend>저자정보</legend>
		<div><label>code</label><input name="au_code" placeholder=""></div>
		<div><label>저자명</label><input name="au_name" placeholder=""></div>
		<div><label>전화번호</label><input name="cp_tel" placeholder="" type="tel"></div>
		<div><label>주소</label><input name="cp_addr" ></div>
		<div><label>주요장르</label><input name="cp_genre" ></div>
		<div class="btn_box">
		<button type="button" class="btn_save_author">저장</button>
		<button type="reset" class="btn_reset_author">다시작성</button>
		<button type="button" class="btn_list_author">리스트</button>
		
		</div>
		</fieldset>
	</form>
	<script>
	    // const : 상수를 선언하는 키워드
	    // 		코드가 진행되는 동안 값이 변경되면 안되는 것
		const doc = document;
		
		doc
		.querySelector("button.btn_delete")
		.addEventListener("click",(e)=>{
			doc
			.querySelector("input[name='cpcode']")
			
			const cpcodeObj = doc
							.querySelector("input#cpcode")
							
			let cpcode = cpcodeObj.value
			if(confirm(cpcode + " 를 삭제합니다!!")) {
				location.replace(
					"${rootPath}/comp/delete?cp_code=" + cpcode
				);
			}
		})
	</script>
	
</body>
</html>