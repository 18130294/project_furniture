<%@page import="com.example.furniture.model.SubCategory"%>
<%@page import="com.example.furniture.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.example.furniture.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sua san pham</title>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Main CSS-->
  <link rel="stylesheet" type="text/css" href="amind/css/main.css">
  <!-- Font-icon css-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
  <!-- or -->
  <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
  <link rel="stylesheet" type="text/css"
    href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
  <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
</head>
<body onload="time()" class="app sidebar-mini rtl">
<%Product pro = (Product)request.getAttribute("product");
List<Category> category =(List<Category>) request.getAttribute("categories");
List<SubCategory> subCategory =(List<SubCategory>) request.getAttribute("subCategories");

%>
  <!-- Navbar-->
  <header class="app-header">
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
      aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">


      <!-- User Menu-->
     <li><a class="app-nav__item" href="show_account_page"><i class='bx bx-log-out bx-rotate-180'></i> </a>

      </li>
    </ul>
  </header>
  <!-- Sidebar menu-->
   <main class="app-content">
   <div class="row">
      <div class="col-md-12">
        <div class="app-title">
          <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><a href="#"><b>Sửa sản phẩm</b></a></li>
          </ul>
          <div id="clock"></div>
        </div>
      </div>
    </div>
  <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
  <aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="images/img/anhdaidien.jpg" width="50px"
        alt="User Image">
      <div>
        <p class="app-sidebar__user-name"><b>Nguyễn Thị Như Ý</b></p>
      </div>
    </div>
    <hr>
    <ul class="app-menu">
      <li><a class="app-menu__item" href="adminhome"><i class='app-menu__icon bx bx-tachometer'></i><span
            class="app-menu__label">Bảng điều khiển</span></a></li>
      <li><a class="app-menu__item " href="manage_user"><i class='app-menu__icon bx bx-id-card'></i> <span
            class="app-menu__label">Quản lý tài khoản</span></a></li>
      <li><a class="app-menu__item" href="manage_product"><i
            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
      </li>
      <li><a class="app-menu__item" href="manage_invoiceDetail"><i class='app-menu__icon bx bx-task'></i><span
            class="app-menu__label">Quản lý đơn hàng</span></a></li>
    </ul>
  </aside>
<div class="modal-dialog modal-dialog-centered" role="document">
  <div class="modal-content">

    <div class="modal-body">
      <div class="row">
        <div class="form-group  col-md-12">
          <span class="thong-tin-thanh-toan">
            <h5>Chỉnh sửa thông tin sản phẩm</h5>
          </span>
        </div>
      </div>
      <form action="editProduct" method="post">
      <div class="row">
       <div class="form-group col-md-6">
            <label class="control-label">Mã sản phẩm </label>
            <input class="form-control" type="number" value="<%=pro.getIdProduct()%>" name="id" readonly>
        </div>
        <div class="form-group col-md-6">
            <label class="control-label">Tên sản phẩm</label>
          <input class="form-control" type="text" required value="<%=pro.getNameProduct()%>" name="name">
        </div>
        <div class="form-group  col-md-6">
            <label class="control-label">Số lượng</label>
          <input class="form-control" type="number" required value="<%=pro.getSoluongtrongkho()%>" name="soluong">
        </div>
          <div class="form-group col-md-6">
            <label class="control-label">Giá bán</label>
            <input class="form-control" type="number" value="<%=pro.getPrice()%>" name="price">
          </div>
           <div class="form-group col-md-3">
                <label class="control-label">Mô tả</label>
                <input class="form-control" type="text" name="describes">
              </div>
              
            <div class="form-group col-md-3">
                <label for="exampleSelect1" class="control-label">Danh mục</label>
               <select class="selectpicker form-control" style="height: 34px" name="namesc" >
 							        <option disabled selected hidden><%=pro.getIdSubCategories()%></option>
  			<%for(Category c: category) {%>
  		 <optgroup label="<%=c.getNameCategories()%>" >
							<%for(SubCategory sub: subCategory) {%>
								<%if(sub.getIdcategories().equalsIgnoreCase(c.getIdCategories())){%>
								<option ><%=sub.getNameSubcategories()%></option>
								
									<%} %>
									<%} %>								
									<%} %>
									 </optgroup>
							</select>

              </div>
               
      </div>
      <BR>
      <BR>
      <input type="submit" class="btn btn-save" value="Lưu lại">
      </form>
      <a class="btn btn-cancel" data-dismiss="modal" href="CancelEditAndAddPro">Hủy bỏ</a>
      <BR>
    </div>
    <div class="modal-footer">
    </div>
  </div>
  </div>
   </main>
  <script src="amind/js/jquery-3.2.1.min.js"></script>
  <!--===============================================================================================-->
  <script src="amind/js/popper.min.js"></script>
  <script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
  <!--===============================================================================================-->
  <script src="amind/js/bootstrap.min.js"></script>
  <!--===============================================================================================-->
  <script src="amind/js/main.js"></script>
  <!--===============================================================================================-->
  <script src="amind/js/plugins/pace.min.js"></script>
  <!--===============================================================================================-->
  <script type="text/javascript" src="amind/js/plugins/chart.js"></script>
  <!--===============================================================================================-->
 
  <script type="text/javascript">
    //Thời Gian
    function time() {
      var today = new Date();
      var weekday = new Array(7);
      weekday[0] = "Chủ Nhật";
      weekday[1] = "Thứ Hai";
      weekday[2] = "Thứ Ba";
      weekday[3] = "Thứ Tư";
      weekday[4] = "Thứ Năm";
      weekday[5] = "Thứ Sáu";
      weekday[6] = "Thứ Bảy";
      var day = weekday[today.getDay()];
      var dd = today.getDate();
      var mm = today.getMonth() + 1;
      var yyyy = today.getFullYear();
      var h = today.getHours();
      var m = today.getMinutes();
      var s = today.getSeconds();
      m = checkTime(m);
      s = checkTime(s);
      nowTime = h + " giờ " + m + " phút " + s + " giây";
      if (dd < 10) {
        dd = '0' + dd
      }
      if (mm < 10) {
        mm = '0' + mm
      }
      today = day + ', ' + dd + '/' + mm + '/' + yyyy;
      tmp = '<span class="date"> ' + today + ' - ' + nowTime +
        '</span>';
      document.getElementById("clock").innerHTML = tmp;
      clocktime = setTimeout("time()", "1000", "Javascript");

      function checkTime(i) {
        if (i < 10) {
          i = "0" + i;
        }
        return i;
      }
    }
  </script>
</body>
</html>