<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>


<spring:url value="/resources/images" var="images"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Portal</title>
</head>
<body>


<jsp:include page="./shared/header.jsp"/>

<h1 style="color:green">${msg}</h1>
<h1>Cart</h1>
<table class="table table-condensed">
    <thead>
      <tr>
        <th>Item Name</th>
        <th>Price Per Quantity</th>
       	<th>Quantity</th>
       	<th>Total Price</th>
       	<th>Image</th>
       	<th>Remove from Cart</th>
       	<th>Increase Quantity</th>
       	<th>Decrease Quantity</th>
      </tr>
    </thead>
   <tbody>
 <c:forEach items="${itemsList}" var="itemObj">
 		
  		<tr>
  			<td>${itemObj.product.productName}</td>
  			<td>${itemObj.price}</td>
  			<td>${itemObj.quantity}</td>
  			<td>
  			<c:out value="${itemObj.price * itemObj.quantity}"/>
  			</td>
  			
  			<td><img src="${images}/${itemObj.product.image}" style="height:200px;width:200px"/></td>
  			<td>
  				<a href="${contextRoot}/addToCart/deleteItem/${itemObj.itemId}">Remove</a>
  			</td>	
  			<td><a href="${contextRoot}/addToCart/increaseQuantity/${itemObj.itemId}">+</a></td>
  			<td><a href="${contextRoot}/addToCart/decreaseQuantity/${itemObj.itemId}">-</a></td>
  			
  		</tr>
  		
  </c:forEach>
  <tr>
  <td>
  <a href="${contextRoot}/addToCart/placeOrder" class="btn btn-primary">Place Order</a>
  </td>
  </tr>
  </tbody>
</table>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
</body>
</html>