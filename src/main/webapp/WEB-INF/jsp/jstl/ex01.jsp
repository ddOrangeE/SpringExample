<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- jstl core 라이브러리 사용방법 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리</title>
</head>
<body>
	<h2>변수 정의하기 </h2>
	<%-- 변수는 set이라는 키워드 사용해야함 --%>
	
	<%-- int numer1 = 100 --%>
	<%--var= 변수이름, value = 변수값 --%>
	<c:set var="number1" value="100" />
	
	<%-- 저장된 값을 태그 사이에 넣는 방법 --%>
	<c:set var="number2">200</c:set>

	<%-- 변수를 el태그 안에다가 넣어주면 됨 --%>
	<h4>number1 : ${number1}</h4>
	<h4>number2 : ${number2}</h4>

	<h2>변수 출력하기 </h2>
	
	<%-- out 키워드 value= 출력할 값 --%>
	<h4><c:out value="100" /></h4>
	
	<%-- 큰 의미는 없지만 변수이름으로 출력하는 방법 (이렇게도 가능하다..) --%>
	<h4><c:out value="${number1 }" /></h4>
	
	<%-- 수행되는 순서 : el태그 -> jstl --%>
	
	<%-- 장점 --%>
	<c:out value="<script>alert('안녕')</script>" />
	
	<%-- c:out 의 기본속성 excapeXml 을 true로 가지고 있다 --%>
	<c:out value="<script>alert('안녕')</script>" escapeXml="true"/>
	
	<%-- escapeXml : xml도 html 형식임 그러니까 xml문법을 살리겠다라는 뜻!! 즉, 꺽쇠 이런걸 수행시키는 게 아니라 보여주겠다 --%>
	
	<%-- <c:out value="<script>alert('안녕')</script>" escapeXml="false"/> --%>
	
	<h2>조건문</h2>
	
	<c:if test="true">  <!-- 실수로 true안에 공백 들어가버리면 true가 아니게 됨 따옴표 안에 타이트하게 잡아주기 -->
		<h4>조건이 참이다</h4>
	</c:if>
	
	<c:if test="false">
		<h4>조건이 거짓이다!!</h4>
	</c:if>
	
	<%-- el태그 안에서 간단한 비교 연산 --%>
	<%-- el태그 먼저 연산 되고, 그게 맞으면 true로 바뀌고 수행 --%>
	<c:if test="${number1 > 50 }">  <!-- el 태그도 따옴표안에 타이트하게 잡아줘야 비교연산 끝난후 true 나 false에 공백 안생김 -->
		<h4>number1이 50보다 크다!</h4>
	</c:if>
	
	
	<%-- 같다나 같지않다는 간단하니까 부등호 대신 쓰기 
		같다 : eq, 같지 않다 : ne
	--%>
	<%-- if(number1 == 100) --%>
	<c:if test="${number1 eq 100 }">
		<h4>number1은 100이다</h4>
	</c:if>
	
	<c:if test="${number2 ne 100 }">
		<h4>number2는 100이 아니다</h4>
	</c:if>
	
	<%-- model에 있는 데이터가 비워져있는지 아닌지를 확인할 수 있다 --%>
	
	<%-- if(number1 == null --%>
	<%-- 변수가 없다, 객체가 null, 리스트가 비어있다 --%> <%-- 이 세가지를 모두 확인해줄 수 있다 --%>
	<c:if test="${empty number1 }">
		<h4>number1 변수가 없다!</h4>	
	</c:if>

	<%-- if(number2 != null --%>
	<c:if test="${not empty number1 }">
		<h4>number1 변수가 있다</h4>
	</c:if>
	

</body>
</html>