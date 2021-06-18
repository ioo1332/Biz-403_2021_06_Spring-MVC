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
	<section id="main_sec">
		<article>
			<h3>학번</h3>
			<ol>
				<li>학번</li>
			</ol>
		</article>
		<article>
			<h3>이름</h3>
			<ul>
				<li>이름</li>
			</ul>
		</article>
		<article>
			<h3>전공</h3>
			<ul>
				<li>저자정보</li>
			</ul>
		</article>
		<article>
			<h3>학년</h3>
			<ul>
				<li>학년</li>
			</ul>
		</article>
		<article>
			<h3>응시과목</h3>
			<ul>
				<li>응시과목</li>
			</ul>
		</article>
		<article>
			<h3>총점</h3>
			<ul>
				<li>총점</li>
			</ul>
		</article>
		<article>
			<h3>평균</h3>
			<ul>
				<li>평균</li>
			</ul>
		</article>
	</section>
</body>
</html>