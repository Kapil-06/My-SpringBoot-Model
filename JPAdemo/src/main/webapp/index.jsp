<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JPA-Project</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<div class="container">
<br><br>
<h1 class="display-4">JPA Project</h1>
<hr>

<a href="newacc">Open New Account</a>
<br>
<a href="newemp">Add New Employee</a>
<br>
<a href="allemp">Show all employees</a>
<br>
<a href="allacc">Show all accounts</a>
<br>
<a href="Deposit.jsp">Deposit Amount</a>
<br>
<a href="empdelete">Delete Employee</a>
<br>
<a href="newjob">New job posting</a>
<br><br><br>

<form action="searchno" method="post">
Account Number <input type="number" name="accno" autocomplete="off" required>
<input type="submit" value="Search">
</form>

<br><br>
<form action="searchtype" method="post">
    Account Type 
    <select name="acctype">
        <option value="saving">Saving</option>
        <option value="fixed">Fixed</option>
        <option value="current">Current</option>
        <option value="ppf">PPF</option>
    </select>
    <input type="submit" value="Search">
</form>

<br><br>
<hr>
developed by Kapil
<br>
KK&copy;August 2023
</div>

</body>
</html>