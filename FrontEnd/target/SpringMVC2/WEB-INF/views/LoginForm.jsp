<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping Portal</title>
</head>
<body>
 <form action="login" method="POST" class="form-horizontal" id="loginForm">
        
        
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Email: </label>
          <div class="col-md-8">  
           <input type="text" name="email" id="email" class="form-control" required="required"/>
          </div>
          </div>
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control" required="required"/>
          </div>
         </div>
          
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
      	   <input type="submit" value="Login" class="btn btn-primary"/>
          </div>
          </div>-
      </form>
</body>
</html>