<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top:50px">
	<div class="container"> 
        <h2 style="color: darkcyan;">New Car Registration Form</h2>
        <hr>
        <a href="/">Home</a>
        <br>
        <br>
        <form action="addcar" method="post" >
        
            <table>
                <tr>
                    <td>Car Model </td>
                    <td><input type="text" name="carnm" autocomplete="off" required class="form-control form-control-sm"></td>
                </tr>
                <tr>
                    <td>Company </td>
                    <td><input type="text" name="company" autocomplete="off" required class="form-control form-control-sm"></td>
                </tr>
                <tr>
                    <td>Price </td>
                    <td><input type="number" name="price" autocomplete="off" required class="form-control form-control-sm"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" class="btn btn-primary btn-sm"></td>
                </tr>
            </table>
            
        </form>
        
    </div>

</body>
</html>