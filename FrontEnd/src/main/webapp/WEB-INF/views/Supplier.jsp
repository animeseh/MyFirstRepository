<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<div align="center">
	
	<h1>Supplier Page</h1>
	
	<hr/>
	
	<a href="${contextRoot}/admin/getSupplierForm">Add Supplier</a><br/>
	<a href="${contextRoot}/admin/ViewSuppliers">View All Suppliers</a><br/>
	
	
	</div>
</body>
</html>