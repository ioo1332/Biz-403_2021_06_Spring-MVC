<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/include_head.jspf"%>
<meta charset="UTF-8">
<title>대한 고교 성적처리 2021 V1</title>
<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
<body>
	<table>
		<tr id="top">
			<th>학번</th>
			<th>이름</th>
			<th>전공</th>
			<th>학년</th>
			<th>응시과목</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<tr>
			<td>20210001</td>
			<td>홍길동</td>
			<td>컴퓨터공학</td>
			<td>1</td>
			<td>3</td>
			<td>275</td>
			<td>91.6</td>
		</tr>
		<tr>
			<td>20210002</td>
			<td>성춘향</td>
			<td>컴퓨터공학</td>
			<td>1</td>
			<td>2</td>
			<td>180</td>
			<td>90</td>
		</tr>
	</table>
</body>
</html>