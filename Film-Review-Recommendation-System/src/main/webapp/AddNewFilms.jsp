<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NewUsers</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <style>
        .card-registration .select-input.form-control[readonly]:not([disabled]) {
        font-size: 1rem;
        line-height: 2.15;
        padding-left: .75em;
        padding-right: .75em;
        }
        .card-registration .select-arrow {
        top: 13px;
        }
    </style>
    <style>
    .slider {
      width: 100%;
      max-width: 800px;
      margin: 0 auto;
      overflow: hidden;
    }

    .slider-container {
      display: flex;
      animation: slide 9s infinite;
    }

    .slider-item {
      flex: 0 0 100%;
      height: auto;
    }

    @keyframes slide {
      0% {
        transform: translateX(0);
      }
      33.33% {
        transform: translateX(-100%);
      }
      66.66% {
        transform: translateX(-200%);
      }
      100% {
        transform: translateX(0);
      }
    }
  </style>
</head>
<body style="margin-top: 25px;">
    <div class="container-xl">
      <form action="addfilmdata" method="post">
        <table style="border: 1px solid black none ;width: 110%;">
            <tr style="height: 750px;">
                
                <td style="border:1px solid black none ; width: 50%;">
                    <section>    
                              <div >
                                <div class="row g-0">
                                  
                                  <div class="col-xl-6" style="border: 1px solid black none; width: 100%; height: 750px;">
                                    <div class="card-body p-md-3 text-black" >
                                    <h3 class="mb-5 text-uppercase">Upload Film</h3>
                      
                                    <div class="form-outline mb-3">
                                        <input type="text" name="name"  class="form-control" autocomplete="off" placeholder="Film Name">
                                    </div>

                                    <!-- ***************************************************** -->

                                    <div class="row">
                                      <div class="col-md-5 mb-4 pb-2">                 
                                        <div class="form-outline form-white">
                                          <input type="text" name="id"  class="form-control" autocomplete="off"   placeholder="Film ID">
                                        </div>                 
                                      </div>
                                      <div class="col-md-7 mb-4 pb-2">
                                        <div class="form-outline form-white">
                                          <input type="text" name="country" autocomplete="off"  class="form-control" placeholder="Country">
                                        </div>                 
                                      </div>
                                    </div>

                                    <!-- ****************************************************** -->

                                    <div class="row">
                                      <div class="col-md-5 mb-4 pb-2">                 
                                        <div class="form-outline form-white">
                                          <select class="form-control"  name="category" placeholder="Category">
                                            <option value="" disabled selected>Select a Category</option>
                                            <option value="family">Family</option>
                                            <option value="drama">Drama</option>
                                            <option value="horror">Horror</option>
                                            <option value="action">Action</option>
                                            <option value="comedy">Comedy</option>
                                          </select>
                                        </div>                 
                                      </div>
                                      <div class="col-md-7 mb-4 pb-2">
                                        <div class="form-outline form-white">
                                          
                                          <select  name="certificate" class="form-control"  placeholder="Certificate">
                                            <option value="" disabled selected>Select a certificate</option>
                                            <option value="ALL">ALL</option>
                                            <option value="13+">13+</option>
                                            <option value="16+">16+</option>
                                            <option value="18+">18+</option>
                                          </select>
                                        </div>                 
                                      </div>
                                    </div>
                                         
                                    <!-- *********************************************************** -->

                                    <div class="row">
                                      <div class="col-md-5 mb-4 pb-2">                 
                                        <div class="form-outline form-white">
                                          <input type="text" name="language"  class="form-control" autocomplete="off"  placeholder="Language">
                                        </div>                 
                                      </div>
                                      <div class="col-md-7 mb-4 pb-2">
                                        <div class="form-outline form-white">
                                          <input type="number" name="relyear" class="form-control" autocomplete="off"   placeholder="RelYear">
                                        </div>                 
                                      </div>
                                    </div>

                                  <!-- ************************************************************* -->

                                  <div class="form-outline mb-3">
                                    <input type="text" name="director" class="form-control" autocomplete="off"   placeholder="Director">
                                  </div>

                                  <!-- ************************************************************* -->
                                    
                                    
                                  <div class="row">
                                    <div class="col-md-5 mb-4 pb-2">                 
                                      <div class="form-outline form-white">
                                        <input type="text" name="actor"  class="form-control" autocomplete="off"  placeholder="Actor">
                                      </div>                 
                                    </div>
                                    <div class="col-md-7 mb-4 pb-2">
                                      <div class="form-outline form-white">
                                        <input type="text" name="actress" class="form-control" autocomplete="off"  placeholder="Actress">
                                      </div>                 
                                    </div>
                                  </div>

                                  <!-- ************************************************************* -->
                                       
                                  
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
                                    <div class="col-md-7 mb-4 pb-2">
                                      <div class="form-outline form-white">
                                        <input type="text" name="music" class="form-control" autocomplete="off"  placeholder="Music">
                                      </div>                 
                                    </div>
                                  </div>
   
                                  <!-- ************************************************************* -->
                                    
                                  <div class="row">
                                    <div class="col-md-5 mb-4 pb-2">                 
                                      <div class="form-outline form-white">
                                        <input type="number" name="budget" class="form-control" autocomplete="off"  placeholder="Budget">
                                      </div>                 
                                    </div>
                                    <div class="col-md-7 mb-4 pb-2">
                                      <div class="form-outline form-white">
                                        <input type="number" name="collection" class="form-control" autocomplete="off"  placeholder="Collection">
                                      </div>                 
                                    </div>
                                  </div>

                                  <!-- ************************************************************* -->

                                  <div class="form-outline mb-3">
                                    <input type="link" name="link" class="form-control"  autocomplete="off"  placeholder="Youtubelink">
                                  </div>

                                  <!-- *********************************************************** -->
                                  <!-- *********************************************************** -->

                                  <div class="d-grid gap-2">
                                    
                                    <input type="submit" value="Submit" class="btn btn-outline-info">
                                    
                                  </div>
                                  
                                  <p class="text-center text-muted mt-4 mb-0">Have already an account? <a href="#!"
                                    class="fw-bold text-body"><u>Login here</u></a>
                                  </p>
                                    
                      
                                  </div>
                                </div>
                              </div>
                            </div>                        
                        
                      </section>
                </td>
                <td style="width: 25%;">
                    <div class="col-sl-8 d-none d-xl-block">
                        <div class="slider">
                            <div class="slider-container">
                                <div class="slider-item">
                                    <img src="image/film1.jpg" alt="Image 1" style="width: fit-content;" >
                                </div>
                                <div class="slider-item">
                                    <img src="image/film4.png" alt="Image 2" >
                                </div>
                                <div class="slider-item">
                                    <img src="image/film3.jpg" alt="Image 3" style="height: 100%;" >
                                </div>
                                <!-- <div class="slider-item">
                                    <img src="image/film4.png" alt="Image 4" >
                                </div> -->  
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </table>
      </form>
    </div>
</body>
</html>