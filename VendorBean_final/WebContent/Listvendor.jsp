<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

    <jsp:setProperty property="*" name="vendor"/>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 style="color:blue;">Vendor details</h4>
<form>
<table><c:forEach var="v" items="${sessionScope.vendor.getVendorDetails()}">
<tr><td>${v.email}</td>
<td>${v.name}</td>
<td>${v.password}</td>
<td>${v.phoneno}</td>
<td>${v.city}</td>
<tr><br>
   
   </c:forEach>
   </table>
  </form> 
</body>
</html>