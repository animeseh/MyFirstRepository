<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    <spring:url value="/resources/images" var="images"/>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Online Shopping Portal</title>
</head>
<body>

<div align="center">
<h1>Online Shopping Portal</h1>
<hr/>

<br/>


<c:if test="${not empty msgToDisplay }">
<div class="alert alert-success">
	${msgToDisplay }
</div>
</c:if>

<div class="container">
<h3>View All Suppliers </h3>

       <table  class="table table-striped">
  <tr>
        <th>Supplier Id </th>
        <th>Supplier Name </th>
        <th colspan="2">Options</th>
        </tr>
<c:forEach items ="${supplierList}" var="sObj">
<tr>
	<td>${sObj.supplierId}</td>
	<td>${sObj.supplierName}</td>
	<td><a href="${contextRoot}/admin/updateSupplier/${sObj.supplierId}"> <span class="glyphicon glyphicon-edit"></span></a></td>
	<td><a href="${contextRoot}/admin/deleteSupplier/${sObj.supplierId}"> <span class="glyphicon glyphicon-remove"></span></a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</body>
</html>
