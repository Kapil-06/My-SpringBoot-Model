<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 50px;">
    <div class="container">
        <h3>Search Film</h3>
        <hr>
        <br>
        <a href="FilmsReport">All films List</a>
        <br>
        <br>
        <form action="/report" method="post"></form>
        <table style="border: 1px solid;">
            <tr>
                <div class="form-outline mb-3">
                    <input type="number" name="id"  class="form-control" autocomplete="off" placeholder="Film ID">
                </div>
            </tr>
            <tr>
                <div class="d-grid gap-2">                        
                    <input type="submit" value="Submit" class="btn btn-outline-info">
                </div>
            </tr>
        </table>
        
        
        
    </form>
    
    </div>
</body>
</html>