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

		<h3>Add Category</h3>
<form:form action= "${contextRoot}/admin/addCategoryProcess"  method= "post"  modelAttribute="catobj">
       <table border="1" style="background-color:pink;">
       
       
       <form:input type ="hidden" path ="categoryId"/>
  <tr>
        <td>Category Name : </td>
        <td><form:input type ="text" path ="categoryName" /></td>
        </tr>
        
  
  <tr>
        <td>Category Description : </td>
        <td><form:input type ="text" path ="categoryDescription" /></td>
        </tr>      
        
        
        
<td></td>
<td>

		<input type ="submit" value = "Add Category" />


</td>
</tr>
</table>
</form:form>
</div>
</body>
</html>