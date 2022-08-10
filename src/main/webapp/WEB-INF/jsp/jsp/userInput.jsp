<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 추가</title>
</head>
<body>
	<h2>회원정보 추가</h2>
	
	<form method="post" action="/jsp/user/add/view">
		<!-- 이미 userController 에서 @RequestParam 에서 name으로 받기로 했다!! -->
		<label>이름 </label><input type="text" name="name"> <br>
		<label>생년월일 </label><input type="text" name="yyyymmdd"> <br>
		<label>자기소개 </label> <br>
		<textarea rows=5 cols="50" name="introduce"></textarea> <br>
		<label>이메일 주소 </label><input type="text" name="email"> <br>
		<button type="submit">추가</button>
	</form>

</body>
</html>