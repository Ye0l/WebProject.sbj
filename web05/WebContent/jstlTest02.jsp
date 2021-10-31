<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="name" value="${param.name }"/>
<c:choose>
	<c:when test="${name == 'admin' }">
		관리자
	</c:when>
	<c:when test="${name == 'user' }">
		일반 사용자
	</c:when>
	<c:otherwise>
		<form action="jstlTest02.jsp" method="get">
			<input type="text" name="name">
		</form>
	</c:otherwise>
</c:choose><br>
<br>
<% String array[] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
pageContext.setAttribute("array", array);%>
<c:forEach var="i" begin="1" end="<%=array.length %>" varStatus="v">
	${i}, ${v.last}<br>
</c:forEach>
<c:forEach var="i" items="${array}">
	${i}<br>
</c:forEach><br><br>
<c:forTokens var="i" items="가,나,다,라,마,바,사,아" delims=",">
${i }
<c:out value="[c:out ${i}]" default="default"/><br>
</c:forTokens>
</body>
</html>