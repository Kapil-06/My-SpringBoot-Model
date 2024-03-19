<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top: 35px;">
    <div class="container">
        <h1 class="display-4">New Job posting</h1>
        <hr>
        <form method="post" action="addjob">
        <table>
            <tr>
                <td>Company</td>
                <td><input type="text" name="company" required class="form-control"></td>
            </tr>
            <tr>
                <td>Profile</td>
                <td><input type="text" name="profile" required class="form-control"></td>
            </tr>
            <tr>
                <td>Skills</td>
                <td><input type="text" name="skills" required class="form-control"></td>
            </tr>
            <tr>
                <td>Experience</td>
                <td><input type="number" name="experience" required class="form-control"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit" class="btn btn-primary"></td>
                <td></td>
            </tr>
        </table>
		</form>
        </div>

</body>
</html>