<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Form</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div align="center">
	<h1>Online Shopping Portal</h1>
	<hr/>
	
	<br/>
	
	
	<h3>Add Product Form</h3>
	<form:form method="post" action="${contextRoot}/admin/addProductProcess" modelAttribute="productObj" enctype="multipart/form-data" >
		<table>
			
			<tr class="form-group">
				<td>Product Name : </td>
				<td><form:input type="text" path="productName" class="form-control"/></td>
			</tr>
			<tr>
				<td>Description : </td>
				<td><form:input type="text" path="productDescription"/></td>
			</tr>
			<tr>
				<td>Price : </td>
				<td><form:input type="text" path="price"/></td>
			</tr>
			<tr>
				<td>Quantity : </td>
				<td><form:input type="number" path="quantity"/></td>
			</tr>
			<tr>
				<td>Select Category : </td>
				<td>
				
					<form:select path="categoryId">
						<form:option value="0">---------Select Category----------------</form:option>
						<c:forEach items="${categoryList}" var="catObj">
							<form:option value="${catObj.categoryId}">${catObj.categoryName}</form:option>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Select Supplier : </td>
				<td>
					<form:select path="supplierId">
						<form:option value="0">---------Select Supplier----------------</form:option>
						<c:forEach items="${supplierList}" var="sObj">
							<form:option value="${sObj.supplierId}"> ${sObj.supplierName}</form:option>
						</c:forEach>
					</form:select>
				</td>
			</tr>
			
			
			
			 <tr>
				<td>Select Image : </td>
				<td>
					<form:input type="file" id="file" path="pimage" placeholder="Upload Product Image"/>
				</td>
			</tr> 
			
			<tr>
				<td></td>
				<td><input type="submit" value="Add Product"></td>
			</tr>
		</table>
	</form:form>
	
	
		
	
	
	
	
</div>
	

</body>
</html>