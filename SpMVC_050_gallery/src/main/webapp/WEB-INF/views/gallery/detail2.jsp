<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>    
<style>
	div#gallery_info{
		border: 1px solid black;
		margin:0 auto;
		text-align: center;
		width: 50%;
	}
	div#galleryFiles{
		display:flex;
		justify-content:center;
	}
	div#galleryFiles img{
		margin: 5px;
	}

</style>
<div id="gallery_info">
<div id="galleryFiles">
	<c:forEach items="${GALLERY.fileList}" var="FILE" >
		<c:if test="${empty FILE.file_upname }">
		<img src="${rootPath}/files/noimage.png${FILE.file_upname}"height="100px">
		</c:if>
		<c:if test="${not empty FILE.file_upname }">
		<img src="${rootPath}/files/${FILE.file_upname}" height="100px">
		</c:if>
	</c:forEach>
</div>
	<div><h3>제목 : ${GALLERY.g_subject}</h3></div>
	<h5>SEQ : ${GALLERY.g_seq}</h5>
	<div><p>작성일 : ${GALLERY.g_date}</p></div>
	<div><p>작성시각 : ${GALLERY.g_time}</p></div>
	<div><p>작성자 : ${GALLERY.g_writer}</p></div>
	<div><p id="content">내용 : ${GALLERY.g_content}</p></div>
</div>

<div>
	<button class="gallery update">수정</button>
	<button class="gallery delete">삭제</button>
</div>
<script>
let update_button=document.querySelector("button.gallery.update")
let delete_button=document.querySelector("button.gallery.delete")

update_button.addEventListener("click",()=>{
	alert("일련번호 ${GALLERY.g_seq}인 게시물을 수정")
	location.href="${rootPath}/gallery/update"
							+"?g_seq=${GFLIST[0].g_seq}"
})

delete_button.addEventListener("click",()=>{
	if(confirm("일련번호 ${GALLERY.g_seq}인 게시물을 삭제")){
		location.replace("${rootPath}/gallery/delete"+"?g_seq=${GFLIST[0].g_seq}")
	}
})
</script>