<%@page import="com.example.furniture.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Thông tin người dùng</title>

    <!-- Fontfaces CSS-->
    <link href="css_s/font-face.css" rel="stylesheet" media="all">
    <link href="vendors/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendors/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendors/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendors/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendors/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendors/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendors/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendors/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendors/slicks/slick.css" rel="stylesheet" media="all">
    <link href="vendors/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendors/perfect-scrollbars/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css_s/theme.css" rel="stylesheet" media="all">

</head>

<body class="animsition">
<%Users user =(Users)request.getAttribute("user"); %>
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                       <a href="home">Trang chủ</a>
                   <p>Tài khoản ${sessionScope.account.nameUser}</p>
                        <button class="hamburger hamburger--slider" type="button">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
            </div>
            <nav class="navbar-mobile">
                <div class="container-fluid">
                    <ul class="navbar-mobile__list list-unstyled">
                       
                        
                        <li>
                            <a href="user_infor">
                                <i class="far fa-check-square"></i>Thông tin người dùng</a>
                        </li>
                        <li>
                            <a href="order_manage">
                                <i class="fas fa-table"></i>Quản lý đơn hàng</a>
                        </li>
                        
                       
                    </ul>
                </div>
            </nav>
        </header>
        <!-- END HEADER MOBILE-->

        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar d-none d-lg-block">
            <div class="logo">
               <a href="home">Trang chủ > </a>
                   <p>Tài khoản ${sessionScope.account.nameUser}</p>
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                       
                       <li class="active">
                            <a href="user_infor">
                                <i class="far fa-check-square"></i>Thông tin người dùng</a>
                        </li>
                      <li>
                            <a href="order_manage">
                                <i class="fas fa-table"></i>Quản lý đơn hàng</a>
                        </li>
                        
                       
                        
                    </ul>
                </nav>
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->

        <!-- PAGE CONTAINER-->
        <div class="page-container">
            <!-- HEADER DESKTOP-->
            <header class="header-desktop">
               
            </header>
            <!-- HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                             <div class="card">
                                    <div class="card-header">Thông tin tài khoản</div>
                                    <div class="card-body">
                                     
                                        <hr>
                                        <form action="update_infor" method="post" novalidate="novalidate">
                                            <div class="form-group">
                                                <label for="cc-payment" class="control-label mb-1">Họ Tên</label>
                                                <input id="cc-pament" name="nameUser" type="text" class="form-control" aria-required="true" aria-invalid="false" value="<%=user.getNameUser()%>" required="required">
                                            </div>
                                            <div class="form-group has-success">
                                                <label for="cc-name" class="control-label mb-1">Email</label>
                                                <input id="cc-name" name="email" type="email" class="form-control cc-name valid" data-val="true"
                                                    aria-required="true" aria-invalid="false" aria-describedby="cc-name-error" value="<%=user.getEmail()%>" required="required">
                                                <span class="help-block field-validation-valid" data-valmsg-for="cc-name" data-valmsg-replace="true"></span>
                                            </div>
                                            <div class="form-group">
                                                <label for="cc-number" class="control-label mb-1">Số điện thoại</label>
                                                <input id="cc-number" name="sdt" type="tel" class="form-control cc-number identified visa" value="<%=user.getSdt() %>" data-val="true" required="required">
                                                <span class="help-block" data-valmsg-for="cc-number" data-valmsg-replace="true"></span>
                                            </div>
                                             <div class="form-group">
                                                <label for="cc-number" class="control-label mb-1">Địa chỉ</label>
                                                <input id="cc-number" name="diachi" type="text" class="form-control cc-number identified visa" value="<%=user.getDiachi() %>" data-val="true" required="required">
                                                <span class="help-block" data-valmsg-for="cc-number" data-valmsg-replace="true"></span>
                                            </div>
                                            
                                            <div>
                                                <button id="payment-button" type="submit" class="btn btn-lg btn-info btn-block">
                                                   
                                                    <span id="payment-button-amount">Lưu thay đổi</span>
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
     
                            
                            <div class="row">
                            <div class="col-md-12">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendors/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendors/bootstrap-4.1/popper.min.js"></script>
    <script src="vendors/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendors/slicks/slick.min.js">
    </script>
    <script src="vendors/wow/wow.min.js"></script>
    <script src="vendors/animsition/animsition.min.js"></script>
    <script src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendors/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendors/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendors/circle-progress/circle-progress.min.js"></script>
    <script src="vendors/perfect-scrollbars/perfect-scrollbar.js"></script>
    <script src="vendors/chartjs/Chart.bundle.min.js"></script>
    <script src="vendors/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
