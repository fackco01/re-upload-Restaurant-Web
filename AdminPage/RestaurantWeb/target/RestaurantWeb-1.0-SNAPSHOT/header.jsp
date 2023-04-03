<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Home</title>
        <!-- icon logo in title bar -->
        <link rel="icon" href="img/icon_group.png" type="image/icon">
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">



        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <!-- HEADER -->
        <header>
            <!-- TOP HEADER -->
            <div id="top-header">
                <div class="container">
                    <ul class="header-links pull-left">
                        <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i> CoCou@gmail.com</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
                        <li>
                            <c:set var="user" value="${NAME}" scope="session"/>
                            <c:if test="${empty user}">
                                <a href="login.jsp"><i class="fa fa-user-o"></i> Login</a>
                            </c:if>
                            <c:if test="${not empty user}">
                                <div class="dropdown">
                                    <button  onclick="hamDropdown()" class="nut_dropdown">
                                        <i class="bi bi-person"></i>
                                        Hello ${user.getUsername()}
                                    </button>
                                    <div class="noidung_dropdown">
                                        <a id="dropItem" href="Work_In_Progress.jsp">Manager Account</a>
                                        <a id="dropItem" href="LogoutServlet">logout</a>
                                    </div>
                                </div>
                            </c:if>

                        </li>
                    </ul>
                </div>
            </div>
            <!-- /TOP HEADER -->

            <!-- MAIN HEADER -->
            <div id="header">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- LOGO -->
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="HomeServlet" class="logo">
                                    <img src="./img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <!-- /LOGO -->

                        <!-- SEARCH BAR -->
                        <div class="col-md-6">
                            <div class="header-search">
                                <form>
                                    <select class="input-select">
                                        <option value="0">All Categories</option>
                                        <c:forEach items="${listC}" var="c" varStatus="counter">
                                            <option value="${counter.count}">${c.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                    <input class="input" placeholder="Search here" name="search" value=""> <!-- Thêm value search ở đây -->
                                    <button class="search-btn" name="action" value="search" type="submit">
                                        <a href="Work_In_Progress.jsp" style="color: #000000">Search</a>
                                    </button>
                                </form>
                            </div>
                        </div>
                        <!-- /SEARCH BAR -->

                        <!-- ACCOUNT -->
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <!-- Wishlist -->
                                <div>
                                    <a href="#">
                                        <i class="fa fa-heart-o"></i>
                                        <span>Your Wishlist</span>
                                        <div class="qty"></div>
                                    </a>
                                </div>
                                <!-- /Wishlist -->

                                <!-- Cart -->

                                <div>
                                    <a href="ShowCart">
                                        <i class="fa fa-shopping-cart"></i>
                                        <span>Your Cart</span>
                                        <c:set var="number" value="numberCart" scope="session"/>
                                        <div class="qty">
                                            <c:if test="${not empty numberCart}">
                                                ${numberCart.size()}
                                            </c:if>
                                            <c:if test="${empty numberCart}">
                                                0
                                            </c:if>
                                        </div>

                                    </a>
                                </div>
                                <!-- /Cart -->

                                <!-- Menu Toogle -->
                                <div class="menu-toggle">
                                    <a href="#">
                                        <i class="fa fa-bars"></i>
                                        <span>Menu</span>
                                    </a>
                                </div>
                                <!-- /Menu Toogle -->
                            </div>
                        </div>
                        <!-- /ACCOUNT -->
                    </div>
                    <!-- row -->
                </div>
                <!-- container -->
            </div>
            <!-- /MAIN HEADER -->
        </header>
        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <nav id="navigation">
            <!-- container -->
            <div class="container">
                <!-- responsive-nav -->
                <div id="responsive-nav">
                    <!-- NAV -->
                    <ul class="main-nav nav navbar-nav">
                        <li><a href="HomeServlet">Home</a></li>
                        <li><a href="HomeServlet#hot-deal">Hot Deals</a></li>
                        <li>              
                            <div class="dropdown">
                                <a href="Work_In_Progress.jsp">Category</a>
                                <!--                                <a class="btn-btn-secondary dropdown-toggle" data-toggle="dropdown">Category<span class="caret"></span></a>
                                                                <ul class="dropdown-menu">
                                <c:forEach items="${listC}" var="c" varStatus="counter">
                                    <li><a value="${counter.count}" name="category">${c.categoryName}</a></li>
                                </c:forEach>
                        </ul>-->
                            </div>

                        </li>

                    </ul>
                    <!-- /NAV -->
                </div>
                <!-- /responsive-nav -->
            </div>
            <!-- /container -->
        </nav>
        <!-- /NAVIGATION -->

        <script>
            function hamDropdown() {
                document.querySelector(".noidung_dropdown").classList.toggle("hienThi");
            }
        </script>
</html>
