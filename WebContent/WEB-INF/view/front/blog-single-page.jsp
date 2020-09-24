<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<html lang="en">
  <head>
    <title>${companyInfo.name } | Single Blog</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600,700" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/animate.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/magnific-popup.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/aos.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/ionicons.min.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/icomoon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
  </head>
  <body>
    
    <div class="hero-wrap js-fullheight" style="background-image: url('images/bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-8 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">
          	<div class="icon">
          		<a href="index" class="logo">
          			<span class="flaticon-flower"></span>
          			<h1>${companyInfo.name }</h1>
          		</a>
          	</div>
            <h1 class="mb-3 mt-5 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Blog Details</h1>
            <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index">Home</a></span> <span class="mr-2"><a href="blog.html">Blog</a></span> <span>Blog Details</span></p>
          </div>
        </div>
      </div>
    </div>

    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index">${companyInfo.name }</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="index" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="about" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="services" class="nav-link">Services</a></li>
	          <li class="nav-item"><a href="work" class="nav-link">Work</a></li>
	          <li class="nav-item active"><a href="blog" class="nav-link">Blog</a></li>
	          <li class="nav-item"><a href="contact" class="nav-link">Contact</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->

    <section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
          <div class="col-md-8 ftco-animate">
            <h2 class="mb-3">${singleBlog.name }</h2>
            <p>${singleBlog.shortDescription }</p>
            <p>
              <img src="${singleBlog.image }" style="max-width:80%;" alt="Blog Image" class="img-fluid">
            </p>
            <p>${singleBlog.blogText }</p>
            
            <div class="about-author d-flex p-5 bg-light">
              <div class="bio align-self-md-center mr-5">
                <img src="${singleBlog.author.image }" alt="Author Image" class="img-fluid mb-4">
              </div>
              <div class="desc align-self-md-center">
                <h3>${singleBlog.author.name } ${singleBlog.author.surname }</h3>
                <p>${singleBlog.author.about }</p>
              </div>
            </div>
          </div> <!-- .col-md-8 -->
            
          
          <div class="col-md-4 sidebar ftco-animate">  
            <div class="sidebar-box ftco-animate">
              <div class="categories">
                <h3>Categories</h3>
                  <c:forEach items="${categoryList }" var="category">
                	<li><a href="">${category.name } <span>${category.timesUsed }</span></a></li>
                  </c:forEach>
              </div>
            </div>

            <div class="sidebar-box ftco-animate">
              <h3>Popular Blog</h3>
              <c:forEach items="${popularBlogPostList }" var="blog">
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4" href="blog-single?blogId=${blog.id }"><img src="${blog.image}" alt="..." class="img-fluid"></a>               
                <div class="text">
                  <h3 class="heading"><a href="blog-single?blogId=${blog.id }">${blog.name }</a></h3>
                  <div class="meta">
                    <div><span class="icon-calendar"></span> ${blog.dateOptionTwo }</div>
                    <div><span class="icon-person"></span> ${blog.author.name } ${blog.author.surname }</div>
                    <div><span class="icon-eye"></span> ${blog.viewCount }</div>
                  </div>
                </div>
              </div>
              </c:forEach>
            </div>
            
            
            <div class="sidebar-box ftco-animate">
              <h3>Quote</h3>
              <p>"Work smart, stay informed, never give up, and great things will happen."</p>
            </div>
          </div>

        </div>
      </div>
    </section> <!-- .section -->

     <footer class="ftco-footer ftco-section img">
    	<div class="overlay"></div>
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-3">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Opening Hours</h2>
              <p>${companyInfo.workTime }</p>
              <ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-5">
                <li class="ftco-animate"><a href="${companyInfo.twitter }"><span class="icon-twitter"></span></a></li>
                <li class="ftco-animate"><a href="${companyInfo.facebook }"><span class="icon-facebook"></span></a></li>
                <li class="ftco-animate"><a href="${companyInfo.instagram }"><span class="icon-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-md-4">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Recent Blog</h2>
              <c:forEach items="${recentBlogPostList }" var="blog">
              <div class="block-21 mb-4 d-flex">
                <a class="blog-img mr-4" href="blog-single?blogId=${blog.id }"><img src="${blog.image}" alt="..." class="img-fluid"></a>
                <div class="text">
                  <h3 class="heading"><a href="blog-single?blogId=${blog.id }">${blog.name }</a></h3>
                  <div class="meta">
                    <div><span class="icon-calendar"></span> ${blog.dateOptionOne }</div>
                    <div><span class="icon-person"></span> ${blog.author.name } ${blog.author.surname }</div><br>
                    <div><span class="icon-eye"></span> ${blog.viewCount }</div>
                  </div>
                </div>
              </div>
              </c:forEach>
            </div>
          </div>
          <div class="col-md-2">
             <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">Partners</h2>
              <ul class="list-unstyled">
                <c:forEach items="${footerPartnerList }" var="partner">
                  <li><a href="${partner.link }" target="_blank" class="py-2 d-block">${partner.name }</a></li>
                </c:forEach>  
              </ul>
            </div>
          </div>
          <div class="col-md-3">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon icon-map-marker"></span><span class="text">${companyInfo.adress }, ${companyInfo.city }</span></li>
	                <c:if test="${not empty companyInfo.phoneOne }">
	                  <li><span class="icon icon-phone"></span><span class="text">${companyInfo.phoneOne }</span></li>
	                </c:if>
					<c:if test="${not empty companyInfo.phoneTwo }">
	                  <li><span class="icon icon-phone"></span><span class="text">${companyInfo.phoneTwo }</span></li>
	                </c:if>
	                <li><span class="icon icon-envelope"></span><span class="text">${companyInfo.email }</span></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12 text-center">
    		<strong>Copyright &copy; 2020 <a href="#">Pavle Janjic</a>.</strong> All rights reserved.
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/jquery.easing.1.3.js"></script>
  <script src="${pageContext.request.contextPath }/js/jquery.waypoints.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/jquery.stellar.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/owl.carousel.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/jquery.magnific-popup.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/aos.js"></script>
  <script src="${pageContext.request.contextPath }/js/jquery.animateNumber.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/bootstrap-datepicker.js"></script>
  <script src="${pageContext.request.contextPath }/js/jquery.timepicker.min.js"></script>
  <script src="${pageContext.request.contextPath }/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="${pageContext.request.contextPath }/js/google-map.js"></script>
  <script src="${pageContext.request.contextPath }/js/main.js"></script>
    
  </body>
</html>