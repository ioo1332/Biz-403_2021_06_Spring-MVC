<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h1>form</h1>
	<button id="form_1">json전송</button>
	<button id="form_2">home전송</button>
	<form id="user_form" method="POST">
		<div>
			<label>user_id</label> <input name="user_id">
		</div>
		<div>
			<label>name</label> <input name="name">
		</div>
		<div>
			<label>tel</label> <input name="tel">
		</div>
		<div>
			<label>age</label> <input name="age">
		</div>
	</form>
</body>
<script>
var rootPath="${rootPath}"
</script>
<script src="{rootPath}/static/form.js?ver=2021-07-20-001"></script>
</html>