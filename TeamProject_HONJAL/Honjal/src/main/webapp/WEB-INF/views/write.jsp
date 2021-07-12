<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<form class="write_form" method=POST>
	<h2 class="board_title">글쓰기</h2>
		<fieldset>
			<div class="write_top">
			<c:choose>
				<c:when test="${MENU == 'TIP'}">
					<select name="category">
						<option>말머리</option>
						<option value="TIP-1">청소&amp;세탁</option>
						<option value="TIP-2">요리</option>
						<option value="TIP-3">공간활용</option>
						<option value="TIP-4">기타</option>
					</select>
				</c:when>
				<c:when test="${MENU == 'TALK'}">
					<select name="category">
						<option>말머리</option>
						<option value="TAL-1">정보 TALK</option>
						<option value="TAL-2">자유 TALK</option>
					</select>
				</c:when>
				<c:when test="${MENU == 'REVIEW'}">
					<select name="category">
						<option>말머리</option>
						<option value="REV-1">생활용품</option>
						<option value="REV-2">음식점</option>
						<option value="REV-3">기타</option>
					</select>
				</c:when>
			</c:choose>
				<input name="content_title" class="write_title" /><br />
				<div class="file_box">
					<label for="ex_file">&#128190;</label> <input type="file" id="ex_file" />
				</div>
			</div>
			<textarea name="content_text" class="write_text"></textarea>
			
			<input name="member_num" type="hidden" value="${CONTENT.member_num}"/>
			<input name="member_nname" type="hidden" value="${CONTENT.member_nname}"/>
			<input name="board_code" type="hidden" value="${select[name='category'].value}"/>
			
			<!--
			<input name="content_date" type="hidden" value="${CONTENT.content_date}"/>
			<input name="content_time" type="hidden" value="${CONTENT.content_time}"/>
			<input name="content_view" type="hidden" value="${CONTENT.content_view}"/>
			<input name="content_good" type="hidden" value="${CONTENT.content_good}"/>
			-->
		</fieldset>
		<div class="write_bottom">
			<button id="btn_write" type="submit">등록</button>
			<button type="reset">취소</button>
		</div>
</form>

<script>

let btn_register = document.querySelector("#btn_write")
let input_title = document.querySelector("input[name='content_title']")
let input_text = document.querySelector("input[name='contente_text']")

if(btn_register) {
	btn_register.addEventListener("click", (e) => {
		if(input_title.value === "") {
			alert("제목을 입력해주세요")
			input_title.focus()
			return false
		}
		if(input_text.value === "") {
			alert("내용을 입력해주세요")
			input_text.focus()
			return false
		}
		form.submit()
	})
}

</script>