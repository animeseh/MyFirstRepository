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


<jsp:include page="./shared/header.jsp"/>


<div class="container">

	<h2>Sign Up Form</h2>
	<br>
		
<form:form action="${contextRoot}/registerUser" modelAttribute="userObj">
<div class="form-group">
    <label for="name">Name:</label>
    <form:input type="text" class="form-control" id="name" path="name"/>
  </div>
  <div class="form-group">
    <label for="email">Email address:</label>
    <form:input type="email" class="form-control" id="email" path="email"/>
  </div>
  
  <div class="form-group">
    <label for="password">Password:</label>
    <form:input type="password" class="form-control" id="password" path="password"/>
  </div>
  
  <div class="form-group">
    <label for="phone">Phone Number:</label>
    <form:input type="text" class="form-control" id="phone" path="phone"/>
  </div>
  
  
  <button type="submit" class="btn btn-default">Submit</button>
</form:form>

</div>


<div style="margin-top:300px">
<jsp:include page="./shared/footer.jsp"/>
</div>

</body>
</html>>