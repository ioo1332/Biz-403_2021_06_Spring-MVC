<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<style>
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<section class="main_sec">
		<table>
			<tr>
				<td>${ST.index}
				<th>${Book.bk_Isbn}</th>
				<th>${Book.bk_title}</th>
				<th>${Book.bk_ccode}</th>
				<th>${Book.bk_aacode}</th>
				<th>${Book.bk_date}</th>
				<th>${Book.bk_pages}</th>
				<th>${Book.bk_price}</th>

			</tr>
			<c:choose></c:choose>
				<c:when test="${empty BOOKS}" ><tr><td colspan="7">데이터가 없음</td></tr></c:when>
				<c:otherwise>
				<c:forEach items="${BOOKS }"var="BOOK" varStatus="ST">

			<tr>
				<td>ISBN</td>
				<td>도서명</td>
				<td>출판사</td>
				<td>저자</td>
				<td>출판연도</td>
				<td>가격</td>
				<td>페이지수</td>
			</tr>
			</c:forEach>
			
			</c:otherwise>
			
		</table>

		<div class="btn_box">
			<button class="btn_insert book">도서등록</button>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/include/include_footer.jspf"%>

</body>
<script>
document.querySelector("button.btn_insert.book")
	.addEventListener("click",()=>{
		location.href = "${rootPath}/books/insert";
});
</script>

</html>