<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello , ${sessionScope.shop.details.name}</h5>
	<h4>Cart Contents</h4>
	<table style="background-color: cyan; margin: auto;" border="1">
		<c:forEach var="bk" items="${sessionScope.shop.cartContents}">
			<tr>
				<td>${bk.title}</td>
				<td>${bk.author}</td>
				<td>${bk.price}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>Total Price</td><td></td>
			<td>${sessionScope.shop.total}</td>
		</tr>
	</table>
	<%--discard session --%>
	${pageContext.session.invalidate()}
	<h5>You have logged out....</h5>
	<h5><a href="login.jsp">Visit Again</a></h5>
	

</body>
</html>