<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />
<style>
	div{
		padding:10px 10px;
		border: 1px solid black;
		margin:0 auto;
		width: 50%;
	}
	div#write_sub input{
		padding:7px 10px;
		width:85%;
	}

	label{
		display: inline-block;
		width: 9%;
		text-align: right;
	}
	input,textarea{
		display: inline-block;
		width: 60%;
		padding: 5px;
	}
	textarea#area {
		width: 95%;
		height:250px;
		resize: none; 
		
	}
	button {
		margin:0 auto;
	}	
	div#write_img, div#write_gallery, div#btn_post{
		text-align: right;
		
	}

	
</style>
<form method="POST" enctype="multipart/form-data">	

<div class ="content" id="writer">
	<label>작성자</label>
	<input
		name="g_writer"
		value="${CMD.g_writer}">
</div>
<div class ="content" id="write_date">
	<label>작성일자</label>
	<input
		name="g_date"
		value="${CMD.g_date}">
</div>
<div class ="content" id="write_time">
	<label>작성시각</label>
	<input
		name="g_time"
		value="${CMD.g_time}">
</div>
<div class ="content" id="write_sub">
	<label>제목</label>
	<input name="g_subject"	>
</div>
<div id="write_cont">
	<label></label>
	<textarea id="area" placeholder="내용입력해주세요" name="g_content"></textarea>
</div>
<div id="write_img">
	<label>대표이미지</label>
	<input
		type="file"
		name="one_file">
</div>
<div class ="content" id="write_gallery">
	<label>갤러리</label>
	<input
		type="file"
		multiple="multiple"
		name="m_file">
</div>
<div id="btn_post">
<button>전송</button>
</div>
</form>