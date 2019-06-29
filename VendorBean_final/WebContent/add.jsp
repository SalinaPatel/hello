<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<jsp:useBean id="vendor" class="Bean.VendorBean"></jsp:useBean>
<jsp:setProperty property="*" name="vendor"/>

</head>



<body>
<h5 style="color:olive;">${vendor.RegisterVendor()}</h5>
<a href="login.jsp">Login</a>

</body>
</html>