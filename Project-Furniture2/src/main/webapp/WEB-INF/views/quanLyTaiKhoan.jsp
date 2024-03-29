<%@page import="com.example.furniture.model.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Danh sách khách hàng | Quản trị Admin</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Main CSS-->
  <link rel="stylesheet" type="text/css" href="amind/css/main.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
  <!-- or -->
  <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

  <!-- Font-icon css-->
  <link rel="stylesheet" type="text/css"
    href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

</head>

<body onload="time()" class="app sidebar-mini rtl">
<%
List<Users> list =(List<Users>) request.getAttribute("list");
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
      <li><a class="app-menu__item active " href="manage_user"><i class='app-menu__icon bx bx-id-card'></i> <span
            class="app-menu__label">Quản lý tài khoản</span></a></li>
      <li><a class="app-menu__item" href="manage_product"><i
            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
      </li>
      <li><a class="app-menu__item" href="manage_invoiceDetail"><i class='app-menu__icon bx bx-task'></i><span
            class="app-menu__label">Quản lý đơn hàng</span></a></li>
    </ul>
  </aside>
  <main class="app-content">
    <div class="app-title">
      <ul class="app-breadcrumb breadcrumb side">
        <li class="breadcrumb-item active"><a href="#"><b>Danh sách khách hàng</b></a></li>
      </ul>
      <div id="clock"></div>
    </div>

    <div class="row">
      <div class="col-md-12">
        <div class="tile">
          <div class="tile-body">
            <table class="table table-hover table-bordered js-copytextarea" cellpadding="0" cellspacing="0" border="0"
              id="sampleTable">
              <thead>
                <tr>
                  <th width="10"><input type="checkbox" id="all"></th>
                  <th>ID khách hàng</th>
                  <th width="150">Họ và tên</th>
                  <th width="300">Địa chỉ</th>
                  <th>Email</th>
                  <th>SĐT</th>
                  <th width="100">Tính năng</th>
                </tr>
              </thead>
              <tbody>
               <%for(int i=0;i<list.size();i++){ %>
                <tr>
                  <td width="10"><input type="checkbox" name="check1" value="1"></td>
                  <td><%=list.get(i).getIdUser() %></td>
                  <td><%=list.get(i).getNameUser() %></td>
                  <td><%=list.get(i).getDiachi() %> </td>
                  <td><%=list.get(i).getEmail() %></td>
                  <td><%=list.get(i).getSdt() %></td>
                  <td class="table-td-center">
                  <form action="deleteUser" method="post">
                        <input type="hidden" name="idUser" value="<%=list.get(i).getIdUser() %>">
                  <button class="btn btn-primary btn-sm trash" type="submit" title="Xóa"><i class="fas fa-trash-alt"></i>
                    </button>
                    </form>
                  </td>
                </tr>
               <%} %>
               

              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </main>


  <!-- Essential javascripts for application to work-->
  <script src="amind/js/jquery-3.2.1.min.js"></script>
  <script src="amind/js/popper.min.js"></script>
  <script src="amind/js/bootstrap.min.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="src/jquery.table2excel.js"></script>
  <script src="amind/js/main.js"></script>
  <!-- The javascript plugin to display page loading on top-->
  <script src="amind/js/plugins/pace.min.js"></script>
  <!-- Page specific javascripts-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
  <!-- Data table plugin-->
  <script type="text/javascript" src="amind/js/plugins/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="amind/js/plugins/dataTables.bootstrap.min.js"></script>
  <script type="text/javascript">$('#sampleTable').DataTable();</script>
</body>

</html>