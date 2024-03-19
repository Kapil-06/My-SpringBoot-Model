<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 30px;">
    <div class="container">
        <h3>Account Report</h3>
        <hr>
        <a href="index.jsp">Home</a>
        <br>
        <table class="table table-primary">
            <tr style="background-color: rgb(132, 176, 177);">
                <th>Account No</th>
                <th>Name</th>
                <th>Type</th>
                <th>Balance</th>
               
            </tr>
            <c:forEach items="${acclist}" var="al">
	            <tr>
	                <td>${al.accno}</td>
 	                <td>${al.accnm}</td>
 	                <td>${al.acctype}</td>
	                <td>${al.balance}</td>
                
	            </tr>
	        </c:forEach>
        </table>
    </div>
</body>
</html>