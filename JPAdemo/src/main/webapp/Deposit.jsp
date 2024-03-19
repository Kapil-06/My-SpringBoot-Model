<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<div class="container">
<br><br>
<h1 class="display-4">Deposit Amount</h1>
<hr>

<form action="deposit" method="post">
<table>
    <tr>
        <td>Account Number</td>
        <td><input type="number" name="accno" autocomplete="off" required class="form-control"></td>
    </tr>
    <tr>
        <td>Amount</td>
        <td><input type="number" name="amount" autocomplete="off" required class="form-control"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Submit" class="btn btn-primary"></td>
        <td></td>
    </tr>
</table>

</form>

</div>

</body>
</html>