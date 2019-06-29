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
	<h4>${sessionScope.shop.status}</h4>
	<h5>Hello , ${sessionScope.shop.details.name}</h5>
	<form action="category_dtls.jsp">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Choose Category</td>
				<td><select name="category">
						<c:forEach var="cat" items="${sessionScope.shop.categories}">
							<option value="${cat}">${cat}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose Category" /></td>
			</tr>
		</table>
	</form>
	<h5><a href="check_out.jsp">Check Out</a></h5>
</body>
</html>