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
        <h3>Employee Report</h3>
        <hr>
        <a href="index.jsp">Home</a>
        <br>
        <table class="table table-primary">
            <tr style="background-color: rgb(132, 176, 177);">
                <th>Employee ID</th>
                <th>Name</th>
                <th>Department</th>
                <th>Post</th>
                <th>Location</th>
                <th>Salary</th>
            </tr>
            <c:forEach items="${emplist}" var="em">
	            <tr>
	                <td>${em.empno}</td>
 	                <td>${em.empnm}</td>
 	                <td>${em.dept}</td>
	                <td>${em.post}</td>
                    <td>${em.location}</td>
                    <td>${em.salary}</td>
	            </tr>
	        </c:forEach>
        </table>
    </div>
</body>
</html>