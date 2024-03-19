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
	<h2 style="color: lightseagreen;">Your Home Page </h2>
	<hr>
	<a href="/">Home</a>
	<br>
    Welcome <%=session.getAttribute("uid") %>
    <br>
    Email : ${mail}
    <br>
    Mobile no : ${mob}
    <br>
    Address : ${add}
    
    <hr>
    <br>
    <h4><b>Celebrity Information</b></h4>
    
    <table class="table table-bordered">
    	<tr style="background-color:lightblue">
    		<th>Name</th>
    		<th>Mobile</th>
    		<th>Age</th>
    		<th>Country</th>
    		<th>Rating</th>
    	</tr>
        <tr>
            <td>${celebrity.name}</td>
            <td>${celebrity.mob}</td>
            <td>${celebrity.age}</td>
            <td>${celebrity.country}</td>
            <td>${celebrity.rating}</td>
        </tr>
    </table>
    </div>
</body>
</html>