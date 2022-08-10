<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사용자 정보</title>
</head>
<body>
	<!-- EL Tag -->
	<%-- el 태그 model에 있는 값을 사용하게 해준다. <%= %> 이것과 비슷함 --%>
	<h1>${ title }</h1>
	<%-- 변수로 활용되기 때문에 간단한 계산 가능 --%>
	<table border="1">
		<tr>
			<th>id</th>
			<td>${user.id }</td>
		</tr>
		
		<tr>
			<th>이름</th>
			<%-- el 태그를 통해서 알아서 getter 로 만들어주기 때문에 private 변수라도 가능!! --%>
			<%-- 즉 public 쓰듯이 멤버변수 꺼내쓰면 가능!! (framework 가 사용을 도와줌) --%>
			<td>${ user.name }</td>
		</tr>
		
		<tr>
			<th>생년월일</th>
			<td>${ user.yyyymmdd }</td>
		</tr>
		
		<tr>
			<th>자기소개</th>
			<td>${ user.introduce }</td>
		</tr>
	</table>

</body>
</html>