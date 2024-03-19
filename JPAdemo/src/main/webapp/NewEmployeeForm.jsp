<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 30px;">
    <div class="container" style="width: 50%;">
        <h3>Employee Form</h3>
        <hr>
        <form action="addemp" method="post">
        <table>
            <tr>
                <td>Employee No</td>
                <td><input type="text" name="empno" class="form-control"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="empnm" class="form-control"></td>
            </tr>
            <tr>
                <td>Department</td>
                <td><input type="text" name="dept" class="form-control"></td>
            </tr>
            <tr>
                <td>Post</td>
                <td><input type="text" name="post" class="form-control"></td>
            </tr>
            <tr>
                <td>Location</td>
                <td><input type="text" name="location" class="form-control"></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><input type="text" name="salary" class="form-control"></td>
            </tr>
            <tr>
                <td>
                <input type="submit" value="Submit" class="btn btn-primary">
                </td>
            </tr>
        </table>
    </form>
    <hr>
</body>
</html>