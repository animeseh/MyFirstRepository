<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Portal</title>
</head>
<body>
	<div align="center">
	
	<h1>Product Page</h1>
	
	<hr/>
	
	<a href="${contextRoot}/admin/getProductForm">Add Product</a><br/>
	<a href="${contextRoot}/admin/ViewProducts">View All Products</a><br/>
	
	
	</div>
</body>
</html>