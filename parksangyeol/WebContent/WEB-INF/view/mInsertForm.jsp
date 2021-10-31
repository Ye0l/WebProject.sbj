<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 입력</title>
</head>
<body>
<h2>Insert Member</h2>
<form action="insert.do" method="post">
ID: <input type="text" id="id"><br>
PWD: <input type="password" id="pwd"><br>
이름: <input type="text" id="name"><br>
Email: <input type="text" id="email"><br>
<input type="submit" value="submit">
</form>
</body>
</html>