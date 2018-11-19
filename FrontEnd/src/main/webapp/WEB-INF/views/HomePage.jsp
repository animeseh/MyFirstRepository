<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<spring:url value="/resources/images" var="images"/>

<!DOCTYPE html>
<html lang="en">
<head>

  <title>Online Shopping Portal</title>
  <meta charset="utf-8">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<!-- <style>	
	.navbar-inverse {
		background-color:#8080ff;
		color:#ff0000;
	}
	.navbar-inverse ul li {
		font-weight:bold;
	}
</style> 
 --><body>

<!-- header.jsp -->
<jsp:include page="./shared/header.jsp"/>


<div class="container">
    
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="${images}/Banner1.jpg" alt="Los Angeles" style="width:100%;height:500px">
      </div>

      <div class="item">
        <img src="${images}/Banner2.jpg" alt="Chicago" style="width:100%;height:500px">
      </div>
    
      <div class="item">
        <img src="${images}/Banner3.jpg" alt="New york" style="width:100%;height:500px">
      </div>
      <div class="item">
        <img src="${images}/Banner6.jpg" alt="New york" style="width:100%;height:500px">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

<br/>

<div class="jumbotron">
    <h3 style="text-align:center;font-family:serif;">--------Online Shopping Portal---------</h3> 
    <p style="font-family:monospace;">It is a form of electronic commerce which allows customers to directly buy goods or services from a seller over the internet using a web browser.</p> 
  </div>

</div>



<!-- Footer -->
<jsp:include page="./shared/footer.jsp"/>

</div>
</div>
</body>
</html>
