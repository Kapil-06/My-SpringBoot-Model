<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 50px;">
    <div class="container">
        <h3>Films Report</h3>
        <hr>
        <br>
        <table class="table table-bordered table-hover">
            <tr style="background-color:rgb(187, 158, 221)">
                <th>ID</th>
                <th>Name</th>
                <th>Language</th>
                <th>Country</th>
                <th>Category</th>
                <th>RelYear</th>
                <th>Certificate</th>
                <th>Director</th>
                <th>Actor</th>
                <th>Actress</th>
                <th>Music</th>
                <th>Platform</th>
                <th>Budget</th>
                <th>Collection</th>
                <th>YouTube Link</th>
            </tr>
            
            <c:forEach items="${data}" var="d">
                <tr>
                    <td>${d.id}</td>
                    <td>${d.name}</td>
                    <td>${d.language}</td>
                    <td>${d.country}</td>
                    <td>${d.category}</td>
                    <td>${d.relyear}</td>
                    <td>${d.certificate}</td>
                    <td>${d.director}</td>
                    <td>${d.actor}</td>
                    <td>${d.actress}</td>
                    <td>${d.music}</td>
                    <td>${d.platform}</td>
                    <td>${d.budget}</td>
                    <td>${d.collection}</td>
                    <td>${d.link}</td>
                    
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>