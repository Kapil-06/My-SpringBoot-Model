<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>firstproject</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top:50px">
	<div class="container">
		<h2 style="color: lightseagreen;">My First SpringBoot Project</h2>
		<hr>
		<form action="login" method="post">

			<table>
				<tr>
					<td>UserId</td>
					<td><input type="text" name="userid" autocomplete="off" required class="form-control"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="pass" autocomplete="off" required class="form-control"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" class="btn btn-primary"></td>
					<td></td>
				</tr>
			</table>
		</form>
		<br>
		<a href="newuser">Register New User</a>
		<hr>
		<a href="product">Perform operation on Products</a>
		<hr>
		&copy;kapilkk2023
	</div>
</body>
</html>