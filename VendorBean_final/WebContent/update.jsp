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
<jsp:setProperty property="email" name="vendor"/>
<jsp:setProperty property="phoneno" name="vendor"/>
<jsp:setProperty property="city" name="vendor"/>


<body>

<h2 Style="color:green;">${sessionScope.vendor.UpdateVendor()}</h2>
<h3>hello in update</h3>
<!--<c:redirect url="Vdetails.jsp"></c:redirect> -->
</body>
</html>