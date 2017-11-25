<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="<c:url value="/style.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h1 {
    text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <div class="form">
<form class="login-from" action="SendEmail" method="post">  
<input type="text" placeholder="Username" name="userName"/><br/>    
<input type="text" placeholder="Email" name="userEmail"/><br/>  
<input type="hidden" name="tempPass" value="password">
<br/>    
<button type="submit"  value="SendEmail">Reset Password</button>    
</form> 
</div>






</body>
</html>