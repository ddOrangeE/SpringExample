<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%--prefix가 c니까 <c: 로 시작하고, prefix가 fmt 니까 <fmt:로 시작하고 ::: 접두사 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL format 라이브러리</title>
</head>
<body>
	<h2>JSTL fmt</h2>
	
	<%-- core 라이브러리, format라이브러리 둘다 필요!! 쓸 수 있어야 하니까 --%>
	
	<c:set var="number" value="123456789" />
	
	<h3>숫자출력</h3>
	<%-- 가장 기본 기능(?): formatNumber --%>
	<h4><fmt:formatNumber value="${number }" /></h4>
	
	<%-- 숨겨진 기본 속성 --%>
	<h4><fmt:formatNumber value="${number }" type="number" groupingUsed="true" /></h4>
	
	<%-- false 하면 적용안되고 내가 지정한 그대로 나옴 --%>
	<h4><fmt:formatNumber value="${number }" type="number" groupingUsed="false" /></h4>
	
	<h3>percent</h3>
	<h4><fmt:formatNumber value="0.35" type="percent" /></h4>
	<h4><fmt:formatNumber value="1" type="percent" /></h4>
	<h4><fmt:formatNumber value="${3 / 5 }" type="percent" /></h4>
	
	<%-- 전화 아님 ㅋㅋ 돈임 --%>
	<h3>통화</h3>
	<h4><fmt:formatNumber value="${number }" type="currency" /></h4>
	<%-- 컴퓨터 기반의 설정에 따라 바꿔준다 --%>
		
	<%-- 국가 상관 없이 달러로 표현하고 싶다 --%>
	<%-- 내가 표현하고 싶은 단위 적어주면 됨 --%>
	<h4><fmt:formatNumber value="${number }" type="currency" currencySymbol="$" /></h4>	

	<%-- 출력될 내용을 바로 출력하는 게 아니라 변수에 저장하는 방법 --%>
	<h4>포메팅 저장</h4>
	<h4><fmt:formatNumber value="${number }" type="currency" currencySymbol="$" var="doller" /></h4>
	
	<%-- var 을 추가해주면 출력이 아니라 저장이 된다 --%>
	<h4>포메팅 저장 출력 : ${doller }</h4>
	
	<h3>숫자 패턴</h3>
	<c:set var="pi" value="3.1415926535897932384" />
	<h4><fmt:formatNumber value="${pi }" /></h4> <%-- 지멋대로 줄여버렸어ㅜㅜ 심지어 반올림 ㅋ --%>
	
	<%-- 우리가 원하는 대로 pi 출력 --%>
	<h4><fmt:formatNumber value="${pi }" pattern="#.##" /></h4>   <%-- #의 개수만큼 출력 --%>
	<h4><fmt:formatNumber value="${pi }" pattern="#.######################" /></h4>
	
	<h4><fmt:formatNumber value="${pi }" pattern="0.00" /></h4>   <%-- 0의 개수만큼 출력 --%>
	<h4><fmt:formatNumber value="${pi }" pattern="0.00000000000000000000000" /></h4>  
	
	
	<%-- # : 자리수가 넘어가면 개수대로 표현 안해줌(표시가능한 만큼만 표시) ,  0 : 자리수가 넘어가면 0으로 채워줌 --%>
	
	<hr>
	
	<%-- 이걸 제일 많이 씀 --%>
	<h3>날짜 포맷</h3>
	<h3>Date 객체를 내가 원하는 형태로 표현</h3>
	
	<%-- 자바 객체이기 때문에 자바에서 만들어서 줘야함 --%>
	<%-- simpledate 형태로 그대로 쓸 수 있다 --%>
	<h4>${now }</h4>
	<h4><fmt:formatDate value="${now }" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" /></h4>
	
	<h4>${dateString }</h4>
	
	<%-- jsp 에서 문자열 쪼개고 막 그럴 수 없자나ㅜㅜ --%>
	
	<%-- "2022/08/12 18:18:20" --%>
	
	<%-- 어떤게 뭔지를 알려줘야한다 --%>
	
	<h3>문자열을 Date 객체로 전환</h3>
	<fmt:parseDate value="${dateString }" pattern="yyyy/MM/dd HH:mm:ss" var="date"/> <%-- 알려주는 방법 --%>
	${date }
	

</body>
</html>