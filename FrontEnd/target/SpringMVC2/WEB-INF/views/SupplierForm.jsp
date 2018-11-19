<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Online Shopping Portal</h1>
<hr/>

<br/>

		<h3>${heading}</h3>
<form:form action= "${contextRoot}/admin/addSupplierProcess"  method= "post"  modelAttribute="sObj">
       <table border="1" style="background-color:pink;">
  
  
  		
  		<form:input type ="hidden" path ="supplierId"/>
        
		
		<tr>
        <td>Supplier Name : </td>
        <td><form:input type ="text" path ="supplierName" /></td>
        </tr>
        <tr>
        
		<td></td>


		<td><input type ="submit" value = "${button}" /></td>
		</tr>

</td>
</tr>
</table>
</form:form>
</div>
</body>
</html>