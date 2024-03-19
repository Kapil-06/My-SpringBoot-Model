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
    <div class="container" style="width: 50%;">
        <h3>Modify Platform & Collection</h3>
        <hr>
        <br>
       
        <form action="updatefilmdata" method="post">
            
            <div class="row">
                <div class="col-md-5 mb-4 pb-2">                 
                    <div class="form-outline form-white">
                        <input type="text" name="id"  class="form-control" autocomplete="off"   placeholder="Film ID">
                    </div>                 
                </div>
            </div>

            <div class="row">
                <div class="col-md-5 mb-4 pb-2">                 
                  <div class="form-outline form-white">
                    
                    <select class="form-control" name="platform" placeholder="platform">
                      <option value="" disabled selected>Select a platform</option>
                      <option value="Netflix">Netflix</option>
                      <option value="Amazon">Amazon</option>
                      <option value="Hotstar">Hotstar</option>
                      <option value="YouTube">YouTube</option>
                      <!-- Add more platform options as needed -->
                    </select>
                  </div>                 
                </div>
            </div>

            <div class="row">
                <div class="col-md-5 mb-4 pb-2">
                    <div class="form-outline form-white">
                      <input type="number" name="collection" class="form-control" autocomplete="off"  placeholder="Collection">
                    </div>                 
                </div>
            </div>

            <div class="row">
                <div class="col-md-5 mb-4 pb-2">
                    <div class="form-outline form-white">
                        <input type="submit" value="Submit" class="btn btn-outline-info">
                    </div>                 
                </div>
            </div>
            
        </form>
        </div>
    </div>

</body>
</html>