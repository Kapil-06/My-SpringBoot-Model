<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Accounts</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 30px;">
    <div class="container" style="width: 50%;">
        <h3>Account form</h3>
        <hr>
        <form action="addacc" method="post">
            Account No :
            <input type="number" name="accno" class="form-control">
            <br>
            Name : 
            <input type="text" name="accnm" class="form-control">
            <br>
            Type :
            <select name="acctype" class="form-control">
                <option value="fixed">Fixed</option>
                <option value="saving">Saving</option>
                <option value="current">Current</option>
                <option value="ppf">PPF</option>
            </select>
            <br>
            Balance :
            <input type="number" name="balance" class="form-control">
            <br>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>