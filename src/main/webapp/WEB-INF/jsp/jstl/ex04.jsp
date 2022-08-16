<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 함수 라이브러리</title>
</head>
<body>
	<%-- el 태그 안에 바로 함수를 수행하는 것이 일반적 --%>
	
	<c:set var="str1" value="No pain. No gain." />
	
	<h2>길이 구하기</h2>
	<h4>${fn:length(str1) }</h4>

	<h2>특정 문자열이 존재하는지?</h2>
	
	<%-- str1 이라는 단어안에 NO 라는 단어가 존재하는 지 --%>
	<h4>No 가 존재하는 가? ${fn:contains(str1, "No") }</h4> <!-- true, false 를 return 해줌 -->
	<h4>No 가 존재하는 가? ${fn:contains(str1, "no") }</h4>
	
	<%-- 항상 주의! el태그 들어가는 따옴표안에 공백 금지! --%>
	<%-- conatinsIgnoreCase : 대소문자 구분 없이 포함되는지 확인해주는 함수 --%>
	<c:if test="${fn:containsIgnoreCase(str1, 'no') }">
		<h4>no라는 단어가 대소문자 구분없이 포함되어 있다!!</h4>
	</c:if> 

	<h2>특정 문자열로 시작, 끝나는지</h2>
	<h4>No로 시작하는 지? ${fn:startsWith(str1, "No") }</h4>
	<h4>gain. 으로 끝나는 지? ${fn:endsWith(str1, "gain.") }</h4>

	<h2>문자열 치환</h2>
	<c:set var="str2" value="I love chicken" />
	
	<%-- 얘도 마찬가지로 문자열 자체를 바꾸어주는 건 아니고 변경된 결과를 return 해줌 --%>
	<h4>${fn:replace(str2, "chicken", "bread") }</h4>
	<h4>${str2 }</h4>

	<h2>문자열 쪼개기</h2>
	<%-- 대상이되는 문자열, 뭘로 쪼갤지 --%>
	<h4>${fn:split(str2, " ")[0] }, ${fn:split(str2, " ")[1] }, ${fn:split(str2, " ")[2] }</h4>
	
	<%-- 쪼개게 되면 배열이 되는 것 --%>
	
	<h2>문자열 자르기</h2>
	
	<%-- 자를 대상, 언제부터, 어디까지(언제부터 + 자를 개수) --%>
	<h4>${fn:substring(str2, 2, 6) }</h4>
	
	<h2>앞뒤 공백 제거</h2>
	
	<c:set var="str3" value="          hello           " />
	<pre>${str3 }</pre> <%-- html 에서는 pre 태그를 꼭 써야 공백까지 다 나오게 보인다 --%>
	
	<pre>trim 함수 사용 : ${fn:trim(str3) }</pre>
	
	
	
</body>
</html>