<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post">
<table>


	<tr><th align="left">Name:</th>
	<td><input type="text" name="name"></td></tr>
	  <tr><th align="left">	Email:</th><td><input type="text" name="email" required></td></tr>
		<tr><th align="left">Password:</th><td><input type="password" name="password" REQUIRED></td></tr>
		<tr><th align="left">Role:</th><td><input type="text" name="role"></td></tr>
		<tr><th align="left">Mobile No:</th><td><input type="text" name="mno"></td></tr>
		<tr><th align="left">Registration Amount:</th><td><input type="text" name="amt"></td></tr>
		<tr><th align="left">City:</th><td><input type="text" name="city"></td></tr>
		<tr><th align="left">City:</th><td><input type="date" name="dt"></td></tr>
		<tr><td colspan=2><input type="submit" name="btn" value="submit"></td></tr>

</table>
</form>
</body>
</html>