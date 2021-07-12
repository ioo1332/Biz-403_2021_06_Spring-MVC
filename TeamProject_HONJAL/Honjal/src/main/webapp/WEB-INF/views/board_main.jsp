<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<style>
.content_title:hover {
	cursor: pointer;
	text-decoration: underline;
}
</style>

<article class="main_box">
	<h2 class="board_title">
		<c:choose>
			<c:when test="${MENU == 'NOTICE'}">
	    	공지사항
	    	</c:when>
			<c:when test="${MENU == 'INFO'}">
	    	정보게시판
	    	</c:when>
			<c:when test="${MENU == 'TIP'}">
	    	생활 TIP
	    	</c:when>
			<c:when test="${MENU == 'INTERIOR'}">
	    	랜선 집들이
	    	</c:when>
			<c:when test="${MENU == 'TALK'}">
	    	혼잘 TALK
	    	</c:when>
			<c:when test="${MENU == 'REVIEW'}">
	    	리뷰 게시판
	    	</c:when>
			<c:when test="${MENU == 'QNA'}">
	    	자취 Q&A
	    	</c:when>
		</c:choose>
	</h2>
	<div class="search_box">
		<input class="search_input" type="text" placeholder="검색어를 입력하세요" />
		<button class="btn_search">검색</button>
	</div>

	<table class="board">
		<tr>
			<th width="15%">No.</th>

			<c:choose>
				<c:when test="${MENU == 'TIP'}">
					<th width="10%" class="content_head">말머리 <select>
							<option selected>전체</option>
							<option>청소 &amp;세탁</option>
							<option>요리</option>
							<option>공간활용</option>
							<option>기타</option>
					</select>
					</th>
				</c:when>
				<c:when test="${MENU == 'TALK'}">
					<th width="10%" class="content_head">말머리 <select>
							<option selected>전체</option>
							<option>정보TALK</option>
							<option>자유TALK</option>
					</select>
					</th>
				</c:when>
				<c:when test="${MENU == 'REVIEW'}">
					<th width="10%" class="content_head">말머리 <select>
							<option selected>전체</option>
							<option>생활용품</option>
							<option>음식점</option>
							<option>기타</option>
					</select>
					</th>
				</c:when>
			</c:choose>

			<th width="40%">글제목</th>
			<th width="15%">작성자</th>
			<th width="10%">작성일</th>
			<th width="5%">조회</th>
			<c:choose>
				<c:when
					test="${MENU == 'TIP' || MENU == 'INTERIOR' || MENU == 'REVIEW'}">
					<th width="5%">추천</th>
				</c:when>
			</c:choose>
		</tr>
		
		<c:choose>
			<c:when test="${MENU == 'NOTICE' || MENU == 'INFO' || MENU == 'QNA'}">
				<c:forEach items="${CONTENTS}" var="CONTENT">
					<tr data-cnum="${CONTENT.content_num}">
						<td class="content_num">${CONTENT.content_num}</td>
						<td class="content_title">${CONTENT.content_title}</td>
						<td class="member_nname">${CONTENT.member_nname}</td>
						<td class="content_date">${CONTENT.content_date}</td>
						<td class="content_view">${CONTENT.content_view}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:when test="${MENU == 'TIP' || MENU == 'REVIEW'}">
				<c:forEach items="${CONTENTS}" var="CONTENT">
					<tr data-cnum="${CONTENT.content_num}">
						<td class="content_num">${CONTENT.content_num}</td>
						<td class="board_code">${CONTENT.board_code}</td>
						<td class="content_title">${CONTENT.content_title}</td>
						<td class="member_nname">${CONTENT.member_nname}</td>
						<td class="content_date">${CONTENT.content_date}</td>
						<td class="content_view">${CONTENT.content_view}</td>
						<td class="content_good">${CONTENT.content_good}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:when test="${MENU == 'TALK'}">
				<c:forEach items="${CONTENTS}" var="CONTENT">
					<tr data-cnum="${CONTENT.content_num}">
						<td class="content_num">${CONTENT.content_num}</td>
						<td class="board_code">${CONTENT.board_code}</td>
						<td class="content_title">${CONTENT.content_title}</td>
						<td class="member_nname">${CONTENT.member_nname}</td>
						<td class="content_date">${CONTENT.content_date}</td>
						<td class="content_view">${CONTENT.content_view}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:when test="${MENU == 'INTERIOR'}">
				<c:forEach items="${CONTENTS}" var="CONTENT">
					<tr data-cnum="${CONTENT.content_num}">
						<td class="content_num">${CONTENT.content_num}</td>
						<td class="content_title">${CONTENT.content_title}</td>
						<td class="member_nname">${CONTENT.member_nname}</td>
						<td class="content_date">${CONTENT.content_date}</td>
						<td class="content_view">${CONTENT.content_view}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>

	</table>
	<div class="btn_write_box">
		<button class="btn_write">글쓰기</button>
	</div>
	<div class="paging_box">
		<a href="#">&laquo;</a> <a href="#" class="on">1</a> <a href="#">2</a>
		<a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">&raquo;</a>
	</div>
</article>

<script>

document.querySelector(".btn_write").addEventListener("click",(e)=>{
	if(${MENU == 'NOTICE'}) {
		location.href="${rootPath}/notice/write"
	} else if(${MENU == 'INFO'}) {
		location.href="${rootPath}/info/write"
	} else if(${MENU == 'TIP'}) {
		location.href="${rootPath}/tip/write"
	} else if(${MENU == 'INTERIOR'}) {
		location.href="${rootPath}/interior/write"
	} else if(${MENU == 'TALK'}) {
		location.href="${rootPath}/talk/write"
	} else if(${MENU == 'REVIEW'}) {
		location.href="${rootPath}/review/write"
	} else if(${MENU == 'QNA'}) {
		location.href="${rootPath}/qna/write"
	}
})

let table = document.querySelector(".board")
if(table) {
	table.addEventListener("click",(e)=>{
		let rootPath = "${rootPath}";
		let target = e.target
		if(target.tagName === "TD") {
			let tr = target.closest("TR")
			let cNum = tr.dataset.cnum
			if(${MENU == 'NOTICE'}) {
				rootPath += '/notice'
			} else if(${MENU == 'INFO'}) {
				rootPath += "/info"
			} else if(${MENU == 'TIP'}) {
				rootPath += "/tip"
			} else if(${MENU == 'INTERIOR'}) {
				rootPath += "/interior"
			} else if(${MENU == 'TALK'}) {
				rootPath += "/talk"
			} else if(${MENU == 'REVIEW'}) {
				rootPath +="/review"
			} else if(${MENU == 'QNA'}) {
				rootPath += "/qna"
			}
			location.href = rootPath + "/read?content_num=" + cNum;
		}
	})
}

</script>