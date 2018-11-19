<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<spring:url value="/resources/images" var="images"/>

<!DOCTYPE html>
<html lang="en">
<head>

  <title>Online Shopping  Portal]</title>
  <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>
	 <style>	
	.navbar-inverse {
		background-color:#b35900;
		color:#000000;
	}
	.navbar-inverse ul li {
		font-weight:bold;
	}
	
</style>  
<body>

<nav class="navbar navbar-inverse">
  <div class="Online Shopping Portal">
    <div class="navbar-header">
      <a class="navbar-brand" href="http://localhost:7838/SpringMVCDemo/">  OnlineShopping Portal</a>
    </div>
    
    <ul class="nav navbar-nav">
      <li><a href="#">Home</a></li>
        <c:forEach items="${sessionScope.categoryList}" var="catObj">
        	<li><a href="${contextRoot}/viewAllProducts/${catObj.categoryId}">${catObj.categoryName}</a></li>
        </c:forEach>
      
      
      
      <li><a href="#">About Us</a></li>
      <li><a href="#">Contact Us</a></li>
      
      
      <sec:authorize access="hasAuthority('ADMIN')" >
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin Options<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${contextRoot}/admin/getProductPage">Product</a></li>
          <li><a href="${contextRoot}/admin/getCategoryPage">Category</a></li>
          <li><a href="${contextRoot}/admin/getSupplierPage">Supplier</a></li>
     
        </ul>
      </li>
      </sec:authorize>
      
      <sec:authorize access="isAuthenticated()">
    	<li><a href="${contextRoot}/addToCart/viewCart?uEmail=${sessionScope.useremail}">View Cart</a></li>
    </sec:authorize>
      
      
      
    </ul>
    
    <sec:authorize access="isAnonymous()">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${contextRoot}/getSignUpForm"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${contextRoot}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    </sec:authorize>
    
    
    <sec:authorize access="isAuthenticated()">
    	<ul class="nav navbar-nav navbar-right">
    		<li>Welcome :${sessionScope.username}</li>
    		<li><a href="${contextRoot}/dologout">Logout</a></li>
    	</ul>
    </sec:authorize>
  </div>
</nav>