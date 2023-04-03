<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        <title>Register Page</title>
    </head>
    <body id="registerBackground">
        <div class="container-md">
            <div class="possition-relative">
                <div class="position-absolute top-0 start-50 translate-middle-x">
                    <div class="alert alert-warning alert-dismissible fade ${show} text-center" role="alert" style="width:500px">
                        ${ERROR}
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </div>
            </div>
            <div class="row g-3 justify-content-center my-3">
                <div class="col-lg-6 rounded-3" id="colorRegister">
                    <div class="text-center mx-3">
                        <h2 class="text-white mt-3">Create New Account</h2>
                    </div>
                    <form action="RegisterServlet" method="post" >
                        <div class="mt-3">
                            <label class="form-label text-white">Enter Username</label>
                            <input type="text" class="form-control border border-2 border-dark" name="user" value="" required>                                
                        </div>

                        <div class="my-3">
                            <label class="form-label text-white">Enter Password</label>
                            <input type="password" class="form-control border border-2 border-dark" name="pass" value="" required>                                                                
                        </div>
                        <div class="my-3">
                            <label class="form-label text-white">Re-enter Password</label>
                            <input type="password" class="form-control border border-2 border-dark" name="pass1" value="" required>                                                                
                        </div>

                        <div class="my-3">
                            <label class="form-label text-white">Full Name</label>
                            <input type="text" class="form-control border border-2 border-dark" name="name" value="" required>                                                                
                        </div>

                        <div class="text-center my-3">
                            <button type="submit" class="btn btn-outline-light" name="submit">Register</button>
                            <a class="btn btn-outline-primary" name="submit" href="HomeServlet">Cancel Register</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>