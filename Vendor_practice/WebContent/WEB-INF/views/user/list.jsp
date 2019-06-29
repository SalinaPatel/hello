<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="s" items="${requestScope.list}">
<table>
<tr>
<td>${s.name}</td>
<td>${s.email}</td>
<td>${s.password}</td>
<td>${s.role}</td>
<td>${s.city}</td>
<td>${s.phoneno}</td>
<td>${s.reg_date}</td>
<td>${s.amt}</td>
<td><a href='<spring:url value="/user/update?id=${s.id}"/>'>update</a></td>
<td><a href='<spring:url value="/user/delete?id=${s.id}"/>'>delete</a></td>
</tr>
</table>
</c:forEach>


</body>
</html>