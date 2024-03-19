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
<body style="margin-top:50px">

    <div  class="container" style="margin: 30px 120px 0 120px;"> 
                    <h2 style="color: darkcyan;">Product Details List</h2> 
                    <hr>
                    <table class="table table-bordered table-hover">
                        <tr style="background-color:rgb(228, 146, 162)">
                            <th>  Product ID  </th>
                            <th>  Car Name  </th>
                            <th>   Company   </th>
                            <th>   Price   </th>
                        </tr>
                        <c:forEach items="${data}" var="d">
                            <tr>
                                <td>${d.prodid}</td>
                                <td>${d.prodnm}</td>
                                <td>${d.company}</td>
                                <td>${d.price}</td>
                            </tr>
                        </c:forEach>
                    </table> 
                </div>
</body>
</html>