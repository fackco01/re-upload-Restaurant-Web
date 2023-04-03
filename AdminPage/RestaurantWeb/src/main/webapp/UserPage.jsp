<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="~/WEB-INF/styleTable.css" type="text/css"/>
        <title>Display Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">
                <img src="img/Example1.png" alt="" width="35" class="d-inline-block align-text-top">
                USER PAGE
            </a>
            <div class="nav nav-tabs" id="tab-nav" roll="tablist">
                <button class="nav-link active" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-home" type="button" role="tab" aria-controls="nav-home" aria-selected="true">
                    Home
                </button>

                <button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-profile" type="button" role="tab" aria-controls="nav-profile" aria-selected="false">
                    Product
                </button>
            </div>
        </nav>

        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active p-3" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
                <div class="container-lg mt-5">
                    <div class="row justify-content-center">
                        <h2>Hello ${NAME.user}</h2>
                        <div class="col-lg">
                            <div>
                                <table class="table table-primary table-bordered border-light table-hover">
                                    <thead class="table-light">
                                        <tr class="text-center">
                                            <td>UserName</td>
                                            <td>Password</td>
                                            <td>Fullname</td>
                                            <td>Role</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="u" value="${USER}" scope="session"/>
                                        <tr>
                                            <td class="text-center">${u.accID}</td>
                                            <td class="text-center">${u.username}</td>
                                            <td class="text-center"> ${u.password}</td>
                                            <td class="text-center">${u.fullname}</td>
                                            <td class="text-center"> ${u.roleID}</td>

                                            <td class="text-center">
                                                <a class="btn btn-outline-secondary" href="UpdateAcc?user=${u.accID}">Update</a>
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                            <div class="mb-5 text-center">
                                <a class="btn btn-outline-dark mx-3" href="LogoutServlet">Logout</a>
                            </div>
                        </div>                
                    </div>
                </div>
            </div>

            <div class="tab-pane fade p-3" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">

                <div class="container-lg mt-5">
                    <div class="row justify-content-center">
                        <div class="col-lg">
                            <div>
                                <table class="table table-primary table-bordered border-light table-hover">
                                    <thead class="table-light">
                                        <tr class="text-center">
                                            <td>Product ID</td>
                                            <td>Product Name</td>
                                            <td>Quantity</td>
                                            <td>Price</td>
                                            <td>Image</td>
                                            <td>Category ID</td>
                                            <td>User Create</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="p" value="${PRODUCT}" scope="session"/>
                                        <c:forEach items="${p}" var="product">
                                            <tr>
                                                <td class="text-center">${product.PID}</td>
                                                <td class="text-center">${product.nameP}</td>
                                                <td class="text-center"> ${product.quantity}</td>
                                                <td class="text-center">${product.price}</td>
                                                <td class="text-center"><img src="${product.image}" alt="image${product.pName}" style="width: 170px"/></td>
                                                <td class="text-center">${product.categoryID}</td>
                                                <td class="text-center">${product.accID}</td>
                                            </tr>
                                        </c:forEach>


                                    </tbody>
                                </table>
                            </div>
                        </div>                
                    </div>
                </div>
            </div>

        </div>
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>
