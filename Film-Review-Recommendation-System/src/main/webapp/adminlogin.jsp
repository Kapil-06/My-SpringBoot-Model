<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-primary text-white">
                        <h3 class="text-center">Admin Login</h3>
                    </div>
                    <div class="card-body">
                        <form action="login" method="POST" id="adminLoginForm">
                            <div class="form-group">
                                <label for="userid">Userid</label>
                                <input type="text" class="form-control" name="userid" autocomplete="off" required>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <br>
                            <input type="submit" value="Login" class="btn btn-primary">
                            <br>
                            <div class="form-group">
                                <h4 class="small mb-2 pb-sm-2"><a class="text-muted" href="#!">Forgot password?</a></h4>
                        	    <h class="display-9">Don't have an account? <a href="#!" class="link-info" style="color: rgb(11, 140, 239);">Create Account</a></h>
                            </div>
                            </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
