<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

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
		    	<th width="10%" class="content_head">
	            	말머리
		            <select>
		              <option selected>전체</option>
		              <option>청소 &amp;세탁</option>
		              <option>요리</option>
		              <option>공간활용</option>
		              <option>기타</option>
		            </select>
	          	</th>
	    	</c:when>
	    	<c:when test="${MENU == 'TALK'}">
	    		<th width="10%" class="content_head">
		            말머리
		            <select>
		              <option selected>전체</option>
		              <option>정보TALK</option>
		              <option>자유TALK</option>
		            </select>
		         </th>
	    	</c:when>
	    	<c:when test="${MENU == 'REVIEW'}">
		    	<th width="10%" class="content_head">
		            말머리
		            <select>
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
	    	<c:when test="${MENU == 'TIP' || MENU == 'INTERIOR' || MENU == 'REVIEW'}">
		    	<th width="5%">추천</th>
	    	</c:when>
          </c:choose>
        </tr>
        
 		<c:forEach begin="1" end="10">
 			<tr>
 				<c:choose>
	 				<c:when test="${MENU == 'NOTICE' || MENU == 'INFO' || MENU == 'QNA'}">
		 				<c:forEach begin="1" end="5">
		 					<td>테스트 테스트 테스트</td>
		 				</c:forEach>
	 				</c:when>
	 				<c:when test="${MENU == 'TIP' || MENU == 'REVIEW'}">
		 				<c:forEach begin="1" end="7">
		 					<td>테스트 테스트 테스트</td>
		 				</c:forEach>
	 				</c:when>
	 				<c:when test="${MENU == 'INTERIOR' || MENU == 'TALK'}">
		 				<c:forEach begin="1" end="6">
		 					<td>테스트 테스트 테스트</td>
		 				</c:forEach>
	 				</c:when>
 				</c:choose>
 			</tr>
 		</c:forEach>
      </table>
      <div class="btn_write_box">
        	<button class="btn_write">글쓰기</button>
      </div>
      <div class="paging_box">
        <a href="#">&laquo;</a>
        <a href="#" class="on">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">&raquo;</a>
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

</script>