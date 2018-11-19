<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <spring:url var="images" value="/resources/images"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Portal</title>
</head>
<body>

<div align="center">
<h1>Online Shopping Portal</h1>
<hr/>

<br/>

<h3>View All Products </h3>
		<div class="table-responsive">
       <table border="1" style="background-color:cyan;">
  <tr>
        <th>Product Id </th>
        <th>Product Name </th>
        <th>price</th>
        <th>quantity</th>
        <th>Description</th>
        <th>Image</th>
       <sec:authorize access="!hasAuthority('ADMIN')">  
         <th>Add to cart</th>
        </sec:authorize>
       <sec:authorize access="hasAuthority('ADMIN')"> 
        <th>Delete</th>
        <th>Update</th>
        
     </sec:authorize>
        
    </tr>
<c:forEach items ="${productlist}" var="productObj">
<tr>
	<td>${productObj.productId}</td>
	<td>${productObj.productName}</td>
	<td>${productObj.price}</td>
	<td>${productObj.quantity}</td>
	<td>${productObj.productDescription}</td>
	
	<td><img src="${images}/${productObj.image}" style="height:150px;width:150px"></td> 
		
		<sec:authorize access="!hasAuthority('ADMIN')">  
        <td><a href="${contextRoot}/addToCart/${productObj.productId}">ADD TO CART</a></td>
        </sec:authorize>
	
	<sec:authorize access="hasAuthority('ADMIN')">
  			<td><a href="${contextRoot}/admin/deleteProduct/${productObj.productId}">Delete</a></td>
  			<td><a href="${contextRoot}/admin/updateProduct/${productObj.productId}">update</a></td>
  			
  		
  	</sec:authorize>
  		</tr>
  		
</c:forEach>

</table>
</div>
</div>
</div>
</body>
</html>