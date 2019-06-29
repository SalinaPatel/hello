<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color:red;">${sessionScope.vendor.status}</h2>
<form action="validate.jsp" method="get">
UserName:<input type="email" name="email"><br><br>
PassWord:<input type="password" name="password"><br><br>
<input type="submit" name="btn" value="Login">
</form>
</body>
</html>