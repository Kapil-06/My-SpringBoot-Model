<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<body style="margin-top:50px; margin-left: 80px;">
    <div class="container">
        <table style="border:0px solid black; height: 90%;">
            <tr style="border: 0px solid;">
                <td style="border: 0px solid black; width: 35%;">
                    <table style="border: 0px solid black;position: relative;">
                        <tr style="height: 550px;">
                            <td style="width: 450px;">
                                <img src="Register.png" class="img-fluid" alt="Sample photo" style="width: 550;margin-left: 10px;"/>
                            </td>
                        </tr>
                    </table>
                </td>

                <td style="border: 0px solid black;">
                    <h3 class="mb-5 text-uppercase">Create An Account</h3>
                    
                    <form action="register" method="post">
                    <table style="border:0px solid black;  width:350px; height: 100%;">
                        <tr style="border:0px solid black">
                            <td>   
                                
                                <div class="form-outline mb-3">
                                    <input type="text" name="userid" class="form-control"  placeholder="UserID">
                                </div>
                                  
                                <div class="form-outline mb-3">
                                  <input type="password" name="pass"  class="form-control" placeholder="password">
                                </div>

                                <div class="form-outline mb-3">
                                    <input type="text" name="usernm" class="form-control" placeholder="UserName">
                                </div>

                                <div class="input-group mb-3">
                                    <span class="input-group-text" >UserType</span>
                                    <input type="text" name="usertype" class="form-control" placeholder="Customer" disable readonly>
                                </div>

                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="basic-addon1">UserStatus</span>
                                    <input type="text" name="userstatus" class="form-control"  placeholder="Active" disable readonly>
                                </div>

                                <div class="form-outline mb-3">
                                    <input type="number" name="accno" class="form-control" placeholder="Account Number">
                                </div>

                                <div class="form-outline mb-3">    
                                      <select name="branch" class="form-control">
                                        <option selected disabled>Branch</option>
                                        <option value="mumbai">Mumbai</option>
                                        <option value="pune">Pune</option>
                                        <option value="nagpur">Nagpur</option>
                                        <option value="amravati">Amravati</option>
                                      </select>   
                                </div>

                                <div class="form-outline mb-3">
                                    <input type="tel" name="mobile" class="form-control" placeholder="Mobile No">
                                </div>
                  
                                <div class="d-grid gap-2">
                                    <input type="submit" value="Register" class="btn btn-outline-info">
                                </div>
                                  
                                <p class="text-center text-muted mt-4 mb-0">Have already an account? <a href="index.jsp"
                                    class="fw-bold text-body"><u>Login here</u></a>
                                </p>
                                
                            </td>
                        </tr>
                    </table>
                    </form>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>