<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="register.jsp">
		<table style="background-color: cyan; margin: auto;">
			<tr>
				<td>Enter User Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Enter User Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Choose Role</td>
				<td><input type="radio" name="role" value="admin" />Admin</td>
				<td><input type="radio" name="role" value="customer" />Customer</td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><input type="number" name="regAmount" /></td>
			</tr>
			<tr>
				<td>Choose Reg Date</td>
				<td><input type="date" name="regDate" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register Me" /></td>


			</tr>
		</table>
	</form>

</body>
</html>