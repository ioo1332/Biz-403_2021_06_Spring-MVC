<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<style>
	div.ga_box{
		display:flex; 
	}
	div{
		padding:10px 10px;
		border: 1px solid black;
		margin:0 auto;
		width: 50%;
	
	}
	div.ga_box div:first-of-type{
		flex:1;
		
	}
	div#ga_box1 img{
		width:100%;
		height: 100%;
		
	}
	div.ga_box div:last-of-type{
		flex:3;
		background-color: gray;
	}
	div#ga_box2{
		border: 1px solid black;
	}
</style>
<%@ include file="/WEB-INF/views/include/include_gallery_search.jspf" %>
<c:forEach items="${GALLERYS}" var="GALLERY">
<div class="ga_box">
	<div id="ga_box1" >
	<c:if test="${empty GALLERY.g_image }">
		<img src ="${rootPath }/files/noimage.png" width="50px"/>
	</c:if>
	<c:if test="${not empty GALLERY.g_image}">
		<img src="${rootPath}/files/${GALLERY.g_image}" width="50px">
	</c:if>
	</div>
	<div id="ga_box2">
		<h3>
		제목 : <a href="${rootPath}/gallery/detail2/${GALLERY.g_seq}">
		${GALLERY.g_subject }(${GALLERY.g_seq})</a></h3>
		<p>내용 : ${GALLERY.g_content}</p>
	</div>
</div>
</c:forEach>

<%@ include file="/WEB-INF/views/include/include_page_nav.jspf" %>

