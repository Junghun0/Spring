<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수학점</th>
			<th>상세보기</th>
		</tr>
<c:forEach var="i" begin="0" end="${number}">
		<c:if test="${grades[i] ne '0'}">
			<tr>
			<td>${years[i/2]}</td>
			<td>${(i%2)+1}</td>
			<td>${grades[i]}</td>
			<td><ahref="${pageContext.request.contextPath}/courselist?year=${years[i/2]}&semester=${(i%2)+1}">링크</a></td>
			</tr>
		</c:if>
</c:forEach>

	</table>
</body>
</html>