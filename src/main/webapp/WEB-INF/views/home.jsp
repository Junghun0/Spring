<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<table>
		<tr><th>1391062박정훈</th></tr>
		<tr><td><a href="${pageContext.request.contextPath}/classes">교과목조회</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath}/semester_grades">학기별 이수학점</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath}/value_grades">이수구분 별 학점조회</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath}/createcourse">수강신청하기</a></td></tr>
		<tr><td><a href="${pageContext.request.contextPath}/lookupcourse">수강신청조회</a></td></tr>
	</table>
</body>
</html>
