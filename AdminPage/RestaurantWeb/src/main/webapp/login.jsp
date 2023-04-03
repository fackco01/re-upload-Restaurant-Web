<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        <title> LOGIN Page</title>
    </head>
    <body id="backgroundLogin">
        <div class="container-md">
            <div class="possition-relative">
                <div class="position-absolute top-0 start-50 translate-middle-x">
                    <div class="alert alert-${alert} alert-dismissible fade ${show} text-center" role="alert" style="width:500px">
                        ${ERROR}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </div>

            </div>

            <div class="row g-3 justify-content-center my-3">
                <div class="col-lg-6 rounded-3" id="colorDiv">
                    <h2 class="text-light text-center mt-4">LOGIN</h2>
                    <form action="LoginServlet" method="POST">
                        <div>
                            <label for="loginUsername" class="my-2 text-danger">Username</label>
                            <input type="text" class="form-control border-dark" value="" placeholder="Enter username" name="username" >
                        </div>

                        <div class="my-3">
                            <label for="loginPassword" class="my-2 text-danger">Password</label>
                            <input type="password" class="form-control border-dark" value="" placeholder="Enter password" name="pass"> 
                        </div>
                        <div class="text-center">
                            <div class="mb-2">
                                <input type="checkbox" class="form-check-input" id="checkBox" name="check" value="checked">
                                <label for="checkBox" class="form-check-label text-light">Remember me</label>
                            </div>

                            <div class="my-2">
                                <button type="submit" name="btnAction" value="login" class="btn btn-outline-light">Login</button>
                                <a href="registrate.jsp" name="btnAction" class="btn btn-outline-primary">Registration</a>                            
                            </div>
                            <a href="Work_In_Progress.jsp" name="btnAction" class="btn btn-link text-primary">Forget Password or Username</a>

                        </div>                         
                    </form> 
                </div>
            </div>
        </div>

        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>