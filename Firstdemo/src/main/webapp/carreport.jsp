<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top:50px">
	<div class="container"> 
        <h2 style="color: darkcyan;">Car Details List</h2> 
        <hr>
        <table class="table table-bordered table-hover">
            <tr style="background-color:rgb(228, 146, 162)">
                <th>SrNo</th>
                <th>CarName</th>
                <th>Company</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${carlist}" var="cl">
                <tr>
                    <td>${cl.srno}</td>
                    <td>${cl.carnm}</td>
                    <td>${cl.company}</td>
                    <td>${cl.price}</td>
                </tr>
            </c:forEach>
        </table>
        
    </div>
</body>
</html>