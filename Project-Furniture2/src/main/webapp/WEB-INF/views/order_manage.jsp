<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.example.furniture.model.InvoiceDetail"%>
<%@page import="java.util.List"%>
<%@page import="com.example.furniture.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
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
    <title>Quản lý đơn hàng</title>

    <!-- Fontfaces CSS-->
    <link href="css_s/font-face.css" rel="stylesheet" media="all">
    <link href="vendors/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendors/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendors/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendors/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendors/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendors/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendors/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendors/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendors/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendors/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendors/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css_s/theme.css" rel="stylesheet" media="all">
    <style>
    .cancelOrder{
    border-radius: 5px;
    border: 1px solid gray;
     background-color: gray;
    	color:  black;
    }
    .cancelOrder:hover{
        border-radius: 5px;
    border: 1px solid gray;
    background-color: #007bff;
    color: white;
    }
    </style>

</head>

<body class="animsition">
<%
List<Product> listPro = (List<Product>)request.getAttribute("listPro");
List<InvoiceDetail> listInvoiceByUser =(List<InvoiceDetail>)request.getAttribute("listInvoiceByUser");

Locale localeEN = new Locale("vi", "VN");
NumberFormat en = NumberFormat.getInstance(localeEN);
%>
    <div class="page-wrapper">
        <!-- HEADER MOBILE-->
        <header class="header-mobile d-block d-lg-none">
            <div class="header-mobile__bar">
                <div class="container-fluid">
                    <div class="header-mobile-inner">
                        <a class="logo" href="index.html">
                            <img src="images/icon/logo.png" alt="CoolAdmin" />
                        </a>
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
                                <i class="far fa-check-square"></i>Thông tin cá nhân</a>
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
                <a href="home">Trang chủ  </a>
                   <p>Tài khoản ${sessionScope.account.nameUser}</p>
               
            </div>
            <div class="menu-sidebar__content js-scrollbar1">
                <nav class="navbar-sidebar">
                    <ul class="list-unstyled navbar__list">
                			
                			<li>
                            <a href="user_infor">
                                <i class="far fa-check-square"></i>Thông tin cá nhân</a>
                        </li>
                   
                        <li class="active">
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
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                       
                    </div>
                </div>
            </header>
            <!-- END HEADER DESKTOP-->

            <!-- MAIN CONTENT-->
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-9">
                             
                            </div>
                            <div class="col-lg-3">
                             
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <!-- USER DATA-->
                         
                                <!-- END USER DATA-->
                            </div>
                            <div class="col-lg-6">
                                <!-- TOP CAMPAIGN-->
                               
                                <!--  END TOP CAMPAIGN-->
                            </div>
                        </div>
                        <div class="row">
                            
                        </div>
                        <div class="row m-t-30">
                            <div class="col-md-12">
                                <!-- DATA TABLE-->
                                <div class="table-responsive m-b-40">
                                    <table class="table table-borderless table-data3">
                                        <thead>
                                            <tr>
                                                <th>Product</th>
                                                <th></th>
                                                 <th>Price</th>
                                                
                                               <th>Quantity</th>
                                                
                                                <th>Status</th>
                                                <th>Total</th>
                                                <th></th>
                                                
                                            </tr>
                                        </thead>
                                      <%for(int i=0,j=0;i<listInvoiceByUser.size();i++){ %>
                                        <tbody>
                                       
                                            <tr>
                                                <td><%=listPro.get(i).getNameProduct() %></td>
                                                  <td><img src="images/img/<%=listPro.get(i).getImages() %>" style="width: 80px;height: 80px"></td>
                                                
                                                <td><%=en.format(listInvoiceByUser.get(i).getPrice()) %></td>
                                                <td><%=listInvoiceByUser.get(i).getQuantity() %></td>
                                                <td><%=listInvoiceByUser.get(i).getStatuss() %></td>
                                                <td><%=en.format(listInvoiceByUser.get(i).getTotal()) %></td>
                                                <%if(listInvoiceByUser.get(i).getStatuss().equalsIgnoreCase("Đang xử lý")){ %>
                                                <td><a href="cancelOrder?idInvoice=<%=listInvoiceByUser.get(i).getIdOrderDetail()%>"><input class="cancelOrder" type="submit" value="Hủy"></a></td>
                                                <%} %>
                                            </tr>
                                        </tbody>
                                        
                                        <%} %>
                                    </table>
                                </div>
                                <!-- END DATA TABLE-->
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
    <script src="vendors/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendors/chartjs/Chart.bundle.min.js"></script>
    <script src="vendors/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->
