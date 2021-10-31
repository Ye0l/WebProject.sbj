<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- c: 접두어, uri 구분명(http~)를 생략해서 사용하기 위함 -->
<!-- JSTL을 쓰는 이유: jsp파일 내에 자바 코드를 사용하지 않기 위함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>titleTest${id }</title>
</head>
<body>
<c:set var="id" value="gildong" scope="page"/>
<c:set var="income" value="2000000" scope="page"/>
<c:set var="score" value="${param.score }"/>
${id }의 수입은 ${income }입니다.<br>

EL TEST:<br>
${score == null ? "매개변수값이 비어있습니다." : score } <br>

JSTL TEST:<br>
<c:if test="${score == null }" var="result">
매개변수값이 비어있습니다.
</c:if>
<c:if test="${score != null }" var="result">
${score }
</c:if><br>
<br>
<!--<c:set var="chooseTest" value="${param.id }"/> -->
<c:choose>
	<c:when test="${score>200 }">
		값은 ${score } 입니다. 목요일
	</c:when>
	<c:when test="${100<score && score<200 }">
		<form action="test" method="get">
			<input type="text" value="${score}"/>
		</form>
	</c:when>
	<c:when test="${0<score && score<100 }">
		값은 ${score } 입니다. 토요일
	</c:when>
	<c:otherwise>
		none
	</c:otherwise>
</c:choose>
</body>
</html>