<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리</title>
</head>
<body>

	<h2>조건 : if else</h2>
	
	<%-- 일반적으로는 controller 을 통해 값을 전달 받는다 (직접 변수를 저장할 일 거의 없음) --%>
	
	<%-- 몸무게가 70이하면 치킨 80이하면 샐러드 그게 아니면 굶는다 --%>
	
	<c:choose>
		<%-- choose 아래에선 모두 when으로 구분 else 는 otherwise --%>
		<%-- 순서 상관 없이 이중에 하나 선택됨 --%>
		
		<%-- if(weight <= 70) --%>
		<c:when test="${weight <= 70 }">
			<h4>치킨 먹자</h4>
		</c:when>
		
		<%-- else if(weight <= 80 --%>
		<c:when test="${weight <= 80 }">
			<h4>샐러드 먹자</h4>
		</c:when>
		
		<%-- else --%>
		<c:otherwise>
			<h4>그게 아니면</h4>
		</c:otherwise>
	</c:choose>	
	
	<h2>반복문</h2>
	<%-- var: i라는 변수, begin: 뭐부터 시작할지, end: 언제까지 step: 0부터 4까지 반복될 때 i가 변화될 양 --%>

	<%-- for(int i = 0; i < 5; i++) --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i }
	</c:forEach>
	<br>
	
	<%-- jstl 에서 이런 반복문을 잘 쓰지 않음 : 화면 꾸미는 건 화면 띠우는 것에 집중하는 게 좋음 --%>
	<%-- 언제쓰냐!! - 리스트 전달할 때 리스트 반복, jstl 데이터를 보여줄 때 --%>

	<%-- 향상된 for문 생각하면 편함 --%>
	<%-- 향상된 for문 처럼 쓰는 게 가장 일반적 --%>
	
	<%-- var 은 변수를 저장하는 속성이구나 라고 생각해줘도 좋다!! --%>
	
	<%-- var : 새로운 변수, items : model 에서 가져온 list 이름 --%>
	<%-- varStatus: 지금 반복되는 상태를 저장할 변수 --%>
	
	<%-- for(String fruit : fruitLisst) --%>
	
	<c:forEach var="fruit" items="${fruitList }" varStatus="status">
		<h4>${fruit } :::: ${status.count } ${status.index } ${status.first } ${status.last }</h4>
	</c:forEach>
	
	<%-- map 이 저장된 List --%>
	
	<%-- List<Map<String, Object>> userList --%>
	<%-- for(Map<String, Object> user : userList --%>
	
	<c:forEach var="user" items="${userList }" varStatus="status">
		
		<%-- map이니까 그대로 출력하면 안되고 맵을 하나하나 꺼내와야함 --%>
		<!-- <h4>이름 : ${user.get("name") }</h4> -->
		
		<!-- 이건 java 문법이니까 지양해야한다 -->
		
		<!-- jstl (el tag)에서 쉽게 꺼내올 수 있게 해준다 -->
		<h3>${status.count } 번째 사용자 정보</h3>
		<h4>이름 : ${user.name }</h4>
		<h4>나이 : ${user.age }</h4>
		<h4>취미 : ${user.hobby }</h4>
	</c:forEach>
	
	<%-- class형태로 저장된 List 반복 --%>
	<%-- jstl이 map 이면 get함수 쓸거고, class이면 안에 있는 멤버 변수 확인해서 그 안의 getter쓸거기 때문에 거의 사용법은 똑같다 --%>
	
	<table border="1">
		<thead>
			<tr>
				<th>제목</th>
				<th>작가</th>
				<th>출판사</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach var="book" items="${books }">
				<tr>
					<td>${book.title }</td>
					<td>${book.author }</td>
					<td>${book.publisher }</td>
				</tr>		
			</c:forEach>
		</tbody>
	
	</table>
	

</body>
</html>