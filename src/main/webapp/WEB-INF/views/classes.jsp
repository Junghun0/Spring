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
			<th>년도</th><th>학기</th><th>과목코드</th><th>교과명</th><th>이수구분</th><th>학점</th>
		</tr>
		<c:forEach var="class" items="${classes}">
			<tr>
				<td><c:out value="${classes.getYear()}"></c:out></td>
				<td><c:out value="${classes.getSemester()}"></c:out></td>
				<td><c:out value="${classes.getCode()}"></c:out></td>
				<td><c:out value="${classes.getName()}"></c:out></td>
				<td><c:out value="${classes.getValue()}"></c:out></td>
				<td><c:out value="${classes.getGrades()}"></c:out></td>
			</tr>
		</c:forEach>
			
	
	</table>
</body>
</html>