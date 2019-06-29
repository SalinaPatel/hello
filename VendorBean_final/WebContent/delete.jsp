<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="vendor" class="Bean.VendorBean"></jsp:useBean>
<jsp:setProperty property="*" name="vendor"/>
<h2 Style="color:green;">${sessionScope.vendor.Delete_vendor()}</h2>
<body>
<h3>hello in delete</h3>
<a href="index.jsp">Home</a>
</body>
</html>