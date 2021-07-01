<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<c:forEach items="${NEWS_LIST}" var="NEWS">
				<div class="content">
					<div>
					<p class="title">
						<a href="${NEWS.link}" target="_NEW">${NEWS.title}</a>
					</p>
					<p class="origin">
						<a href="${NEWS.originallink}">언론사 바로가기</a>
					</p>
					<p class="desc">${NEWS.description}</p>
						<strong>저자 : </strong>${NEWS.author}</p>
					<p class="publisher">
						<strong>출판사 : </strong>${NEWS.publisher}</p>
						<button class="insert">내 서재등록</button>
				</div>
			</div>
		</c:forEach>