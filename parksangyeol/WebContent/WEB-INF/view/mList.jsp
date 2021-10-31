<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>mList.jsp</h2>
<table>
<tr>
<th>id</th>
<th>pwd</th>
<th>name</th>
<th>email</th>
<th>joinDate</th>
</tr>
<c:forEach var='dto' items = "${dtos}">
<tr>
<td>${dto.id }</td>
<td>${dto.pwd }</td>
<td>${dto.name }</td>
<td>${dto.email }</td>
<td><fmt:formatDate value="${dto.joinDate }"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>