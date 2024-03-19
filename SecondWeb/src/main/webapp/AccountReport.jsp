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
	<h2 style="color: rgb(31, 212, 61);">Account Report </h2>
	<hr>
    <a href="/">Home</a>
    <br>
    <br>
    <table class="table table-bordered table-hover">
        <tr style="background-color: rgb(141, 207, 210);">
            <th style="text-align: center;">Account Number</th>
            <th style="text-align: center;">Account Name</th>
            <th style="text-align: center;">Account Type</th>
            <th style="text-align: center;">Balance</th>
        </tr>
        
        <c:forEach items="${acclist}" var="al">
        <tr>
            <td>${al.accno }</td>
            <td>${al.accnm }</td>
            <td>${al.acctype }</td>
            <td>${al.balance}</td>
        </tr>
        </c:forEach>
        
    </table>
    </div>
</body>
</html>