<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- JB def constr --%>
<jsp:useBean id="shop" class="beans.BookShopBean" scope="session" />
<%--setters  --%>
<jsp:setProperty property="*" name="shop"/>
<body>
<%--invoke B.L method n use the ret value for navigation --%>
<%-- <jsp:forward page="${sessionScope.shop.authenticateCustomer()}.jsp"/>
 --%>
 <c:redirect url="${sessionScope.shop.authenticateCustomer()}.jsp"/>