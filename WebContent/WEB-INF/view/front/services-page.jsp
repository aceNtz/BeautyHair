<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<!DOCTYPE html>
<html lang="en">
  <head>
    <title>${companyInfo.name } | Services</title>
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
            <h1 class="mb-3 mt-5 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Services</h1>
            <p class="breadcrumbs" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"><span class="mr-2"><a href="index">Home</a></span> <span>Services</span></p>
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
	          <li class="nav-item active"><a href="services" class="nav-link">Services</a></li>
	          <li class="nav-item"><a href="work" class="nav-link">Work</a></li>
	          <li class="nav-item"><a href="blog" class="nav-link">Blog</a></li>
	          <li class="nav-item"><a href="contact" class="nav-link">Contact</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
		
		<section class="ftco-section">
    	<div class="container">
    		<div class="row">
          <div class="col-md-4 ftco-animate">
            <div class="media d-block text-center block-6 services">
              <div class="icon d-flex mb-3"><span class="flaticon-facial-treatment"></span></div>
              <div class="media-body">
                <h3 class="heading">Skin &amp; Beauty Care</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>      
          </div>
          <div class="col-md-4 ftco-animate">
            <div class="media d-block text-center block-6 services">
              <div class="icon d-flex mb-3"><span class="flaticon-cosmetics"></span></div>
              <div class="media-body">
                <h3 class="heading">Makeup Pro</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>      
          </div>
          <div class="col-md-4 ftco-animate">
            <div class="media d-block text-center block-6 services">
              <div class="icon d-flex mb-3"><span class="flaticon-curl"></span></div>
              <div class="media-body">
                <h3 class="heading">Hair Style</h3>
                <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic.</p>
              </div>
            </div>    
          </div>
        </div>
    	</div>
    </section>


    <section class="ftco-section ftco-discount img" style="background-image: url(images/bg_2.jpg);">
		<div class="overlay"></div>
		<div class="container">
			<div class="row justify-content-end">
				<div class="col-md-5 discount ftco-animate fadeInUp ftco-animated">
					<h2 class="mb-4">Beauty Pricing</h2>
					<p class="mb-4">"Price is what you pay. Value is what you get."</p>
					<p><a href="${companyInfo.catalogue }" target="_blank" class="btn btn-dark btn-outline-dark px-4 py-3">Download Catalog</a></p>
				</div>
			</div>
		</div>
	</section>	

		<section class="ftco-section ftco-counter img" id="section-counter" style="background-image: url(images/bg_4.jpg);">
			<div class="overlay"></div>
      <div class="container">
        <div class="row justify-content-center">
        	<div class="col-md-10">
        		<div class="row">
		          <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		              	<div class="icon"><span class="flaticon-flower"></span></div>
		              	<span>Makeup Over Done</span>
		                <strong class="number" data-number="3500">0</strong>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		              	<div class="icon"><span class="flaticon-flower"></span></div>
		              	<span>Procedure</span>
		                <strong class="number" data-number="1000">0</strong>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		              	<div class="icon"><span class="flaticon-flower"></span></div>
		              	<span>Happy Client</span>
		                <strong class="number" data-number="3000">0</strong>
		              </div>
		            </div>
		          </div>
		          <div class="col-md-6 col-lg-3 d-flex justify-content-center counter-wrap ftco-animate">
		            <div class="block-18 text-center">
		              <div class="text">
		              	<div class="icon"><span class="flaticon-flower"></span></div>
		              	<span>Skin Treatment</span>
		                <strong class="number" data-number="900">0</strong>
		              </div>
		            </div>
		          </div>
		        </div>
		      </div>
        </div>
      </div>
    </section>

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