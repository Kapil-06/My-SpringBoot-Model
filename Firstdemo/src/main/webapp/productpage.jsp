<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">

<script type="text/javascript">
    function createRequestObject() {
        var tmpXmlHttpObject;
        if (window.XMLHttpRequest) {
            tmpXmlHttpObject = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            tmpXmlHttpObject = new ActiveXObject("Microsoft.XMLHTTP");
        }
    
        return tmpXmlHttpObject;
    }
    
    var http = createRequestObject();
    
    var isFormVisible = false; // Flag to track if the form is already visible

    function showAddCarForm() {
        if (isFormVisible) {
            // Remove the existing form
            document.getElementById('addCarForm').remove();
            isFormVisible = false;
        } else {
            var formHTML = `
                <div id="addCarForm" class="Container" style="margin: 30px 120px 0 120px;">
                    <form method="post" action="addProduct">
                        <h4>Enter Car Details</h4>
                        ProdId
                        <input type="number" name="prodid" class="form-control">
                        <br>
                        Car Model
                        <input type="text" name="prodnm" class="form-control form-control-sm" aria-label=".form-control-sm example">
                        <br>
                        Company
                        <input type="text" name="company" class="form-control form-control-sm" aria-label=".form-control-sm example">
                        <br>
                        Price
                        <input type="number" name="price" class="form-control form-control-sm" aria-label=".form-control-sm example">
                        <br>
                        <input type="submit" value="Submit" class="btn btn-primary btn-sm">
                    </form>
                </div>
            `;
            document.getElementById('res').innerHTML += formHTML; // Append the form to the existing content
            isFormVisible = true;
            
        }
    }
    
    function showProductList() {
        if (isFormVisible) {
            // Remove the existing form
            document.getElementById('ProductList').remove();
            isFormVisible = false;
        } else {
            var formHTML = `
                <div id="ProductList" class="Container" style="margin: 30px 50% 0 150px;">
                    <form method="get" action="searchByCompany">
                        <h4>Enter Car Details</h4>
                        
                        Select Company
                        <select name="company" class="form-control">
                        <option value="">Select an option</option>
                        <option value="Hyundai">Hyundai</option>
                        <option value="BMW">BMW</option>
                        <option value="Honda">Honda</option>
                        <option value="Mercedes">Mercedes</option>
                        <option value="Tata">Tata</option>
                        <option value="Volkswagen">Volkswegan</option>
                        <option value="Audi">Audi</option>
                        <option value="Ford">Ford</option>
                        <option value="Toyota">Toyota</option>
                        <option value="Renault">Renault</option>
                        
                        <!-- Add more options as needed -->
                      </select>
						<br>
                        <input type="submit" value="Submit" class="btn btn-primary btn-sm">
                    </form>
                </div>
            `;
            document.getElementById('res').innerHTML += formHTML; // Append the form to the existing content
            isFormVisible = true;
            
        }
    }
    
	
    function processResponse() {
        if(http.readyState == 4){
            var response = http.responseText;
            document.getElementById('res').innerHTML = response;
        }
    }
</script>
</head>
<body style="margin-top:50px">
    <div class="container">
        <h2 style="color: lightseagreen;">Perform Product Operation</h2>
        <hr>
        <nav class="nav">
            <a class="nav-link" aria-current="page" href="/">Home</a>
            <a class="nav-link" href="#" onclick="showAddCarForm()">Add New Car Product</a>
            <a class="nav-link" href="productdetail" >Car Report</a>
            <a class="nav-link" href="#" onclick="showProductList()">Search By Company</a>
        </nav>
    </div>
    
    <div class="container" style="margin-left: 30px;" id="res"></div>
</body>
</html>
