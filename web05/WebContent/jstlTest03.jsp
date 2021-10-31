<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"></style>
</head>
<body>
	<c:set var="v" value="mon, tur, wed, thu, fri, sat, sun"/>
	<c:forTokens var="i" items="${v}" delims=", ">
		${i}<br>
	</c:forTokens>
	<!-- JSTL format실습 -->
	<fmt:formatNumber value="1234567890" type="currency" currencySymbol="$"/><br>
	<c:set var="now" value="<%=new java.util.Date() %>"/>
	<fmt:formatDate value="${now}"/><br>
	date: <fmt:formatDate value="${now}" type="date"/><br>
	time: <fmt:formatDate value="${now}" type="time"/><br>
	both: <fmt:formatDate value="${now}" type="both"/><br>
	<!-- dateStyle, timeStyle의 날짜, 시간, 형식 4가지(생략: default) -->
	default: <fmt:formatDate value="${now}" type="both" dateStyle="default" timeStyle="default"/><br>
	short: <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short"/><br>
	medium: <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium"/><br>
	long: <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long"/><br>
	full: <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
	pattern: <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/><br>

</body>
</html>