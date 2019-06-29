<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Register</h1>
<div>
<form action="add.jsp" method="get">
UserName: <input type="text" name="vname" id="nm" required><br><br>
Email: <input type="email" name="email" id="email"><br><br>
Password: <input type="password" name="password" id="pass" required><br><br>
Phone Number: <input type="text" name="phoneno" id="phone" required><br><br>
City :<select name="city">
<option value="pune">Pune</option>
<option value="mumbai">Mumbai</option>
<option value="calcutta">Calcutta</option>
<option value="banglore">Banglore</option>
<option value="chennai">Chennai</option>
</select><br><br>
<input type="reset" name="rbtn" value="Reset">&nbsp;&nbsp;
<input type="submit" name="btn" value="Register">
</form>
</div>

</body>
</html>
</body>
</html>