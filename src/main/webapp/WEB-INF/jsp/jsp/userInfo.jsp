<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����� ����</title>
</head>
<body>
	<!-- EL Tag -->
	<%-- el �±� model�� �ִ� ���� ����ϰ� ���ش�. <%= %> �̰Ͱ� ����� --%>
	<h1>${ title }</h1>
	<%-- ������ Ȱ��Ǳ� ������ ������ ��� ���� --%>
	<table border="1">
		<tr>
			<th>�̸�</th>
			<%-- el �±׸� ���ؼ� �˾Ƽ� getter �� ������ֱ� ������ private ������ ����!! --%>
			<%-- �� public ������ ������� �������� ����!! (framework �� ����� ������) --%>
			<td>${ user.name }</td>
		</tr>
		
		<tr>
			<th>�������</th>
			<td>${ user.yyyymmdd }</td>
		</tr>
		
		<tr>
			<th>�ڱ�Ұ�</th>
			<td>${ user.introduce }</td>
		</tr>
	</table>

</body>
</html>