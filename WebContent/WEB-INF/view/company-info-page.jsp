<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>${companyInfo.name } | Company</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

 <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
    </ul>

    
    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <!-- Notifications -->
	  <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">${unreadCounter }</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="message-list?pageId=0" class="dropdown-item dropdown-footer">Show Notifications</a>
        </div>
      </li>
	  <!--  LOGIN -->
     <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-user"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="user-edit-profile" class="dropdown-item">
            <!-- Message Start -->
            <div class="media align-items-center">
              <img src="${principal.image }" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
              	${principal.username }
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="user-password-change" class="dropdown-item">
            <i class="fas fa-user"></i> Change Password
          </a>
          <div class="dropdown-divider"></div>
          <a href="${pageContext.request.contextPath }/login.html" class="dropdown-item">
              
			<form:form action="${pageContext.request.contextPath }/logout">
			  <input type="submit" value="Log out">
			</form:form>

          </a>
        </div>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="front-index" target="_blank" class="brand-link">
      <img src="${companyInfo.logo }" alt="${companyInfo.name } Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">${companyInfo.name }</span>
    </a>

    <div class="sidebar">
	  <!-- Sidebar Menu -->
	  <nav class="mt-2">
	    <ul class="nav nav-pills nav-sidebar flex-column" data-accordion="false" data-widget="treeview" role="menu">
	      <!-- Add icons to the links using the .nav-icon class
	                   with font-awesome or any other icon font library -->
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href="#">
	        <p>Category <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="category-list"><i class="far fa-circle nav-icon"></i>
	            <p>Category List</p></a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="category-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add Category</p></a>
	          </li>
	        </ul>
	      </li>
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href="">
	        <p>Blog Post <i class="right fas fa-angle-left"></i></p></a>
	        <sec:authorize access="hasRole('admin')">
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="blog-post-list?pageId=1"><i class="far fa-circle nav-icon"></i>
	            <p>All Blog Post List</p></a>
	          </li>
	        </ul>
	        </sec:authorize>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="blog-post-list"><i class="far fa-circle nav-icon"></i>
	            <p>My Blog Post List</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="blog-post-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add Blog Post</p></a>
	          </li>
	        </ul>
	      </li>
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href="">
	        <p>Gallery <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="picture-list"><i class="far fa-circle nav-icon"></i>
	            <p>Picture List</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="picture-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add Picture</p></a>
	          </li>
	        </ul>
	      </li>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href="">
	        <p>Message <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="message-list"><i class="far fa-circle nav-icon"></i>
	            <p>All Message List</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="message-list?pageId=1"><i class="far fa-circle nav-icon"></i>
	            <p>Seen Message List</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="message-list?pageId=0"><i class="far fa-circle nav-icon"></i>
	            <p>Not Seen Message List</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href="">
	        <p>User <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="user-list"><i class="far fa-circle nav-icon"></i>
	            <p>User List</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="user-add"><i class="far fa-circle nav-icon"></i>
	            <p>Add User</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href="#">
	        <p>Partner <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="partner-list"><i class="far fa-circle nav-icon"></i>
	            <p>Partner List</p></a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="partner-form"><i class="far fa-circle nav-icon"></i>
	            <p>Add Partner</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	      <sec:authorize access="hasRole('admin')">
	      <li class="nav-item has-treeview">
	        <a class="nav-link" href="">
	        <p>Company <i class="right fas fa-angle-left"></i></p></a>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="company-info"><i class="far fa-circle nav-icon"></i>
	            <p>Company Info</p></a>
	          </li>
	        </ul>
	        <ul class="nav nav-treeview">
	          <li class="nav-item">
	            <a class="nav-link" href="company-info-update"><i class="far fa-circle nav-icon"></i>
	            <p>Company Info Update</p></a>
	          </li>
	        </ul>
	      </li>
	      </sec:authorize>
	    </ul>
	  </nav><!-- /.sidebar-menu -->
	</div><!-- /.sidebar -->
  </aside>


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
     <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Company</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item">Company</li>
              <li class="breadcrumb-item active">Company Info</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Company Info</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <table class="table table-bordered">
                  <thead>                  
                    <tr>
                      <th class="text-center">Logo</th>
                      <th class="text-center">Name</th>
                      <th class="text-center">City</th>
                      <th class="text-center">Adress</th>
                      <th class="text-center">Zip Code</th>
                      <th class="text-center">Email</th>  
                      <th class="text-center">Phone One</th>
                      <th class="text-center">Phone Two</th>
                      <th class="text-center">Social Media</th>
                      <th class="text-center">Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td class="text-center">
                         <img src="${companyInfo.logo }" style="max-width: 80px;">
                      </td>
                      <td class="text-center">
                        ${companyInfo.name }
                      </td>
                      <td class="text-center">
                        ${companyInfo.city }
                      </td>
                      <td class="text-center">
                        ${companyInfo.adress }
                      </td>
                      <td class="text-center">
                        ${companyInfo.zipCode }
                      </td>
                      <td class="text-center">
                        ${companyInfo.email }
                      </td>
                      <td class="text-center">
                        ${companyInfo.phoneOne }
                      </td>
                      <td class="text-center">
                        ${companyInfo.phoneTwo }
                      </td>
                      <td class="text-center">
                        <div class="btn-group">
                          <a href="${companyInfo.facebook }" target="blank"  class="btn btn-light">
                            <i class="fab fa-facebook-f"></i>
                          </a>
                          <a href="${companyInfo.instagram }" target="blank" class="btn btn-light">
                            <i class="fab fa-instagram"></i>
                          </a>
                          <a href="${companyInfo.twitter }" target="blank" class="btn btn-light">
                            <i class="fab fa-twitter"></i>
                          </a>
                          <a href="${companyInfo.catalogue }" target="blank"  class="btn btn-light">
                            <i class="fab fa-elementor"></i>
                          </a>
                        </div>
                      </td>
                      <td class="text-center">
                        <div class="btn-group">
                          <a href="company-info-update" class="btn btn-info">
                            <i class="fas fa-edit"></i>
                          </a>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
              <div class="card-footer clearfix">
                
              </div>
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2020 <a href="#">Pavle Janjic</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="${pageContext.request.contextPath }/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath }/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/dist/js/adminlte.min.js"></script>
</body>
</html>
