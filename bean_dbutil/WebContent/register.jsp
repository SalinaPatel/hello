<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%--create JB n store it under page scope --%>
<jsp:useBean id="bk_shop" class="beans.BookShopBean" />
<jsp:setProperty property="*" name="bk_shop" />
<body>
	<%-- invoke B.L method of JB --%>
	<h5>Reg Status : ${bk_shop.registerCustomer()}</h5>
	<%-- discard session --%>
	${pageContext.session.invalidate()}
	<h5>
		<a href="login.jsp">Proceed To Login</a>
	</h5>
</body>
</html>