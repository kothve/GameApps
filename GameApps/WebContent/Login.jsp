<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Olivier Mercier Peetz 2718100</title>
<link href="<c:url value="/style.css" />" rel="stylesheet">
<style>
h1 {
    text-align: center;
}
p {
    text-align: center;
}

</style>
</head>
<body>




<h1>GAME APPS</h1>  




<div class="login-page">
  <div class="form">
<form class="login-from"  action="LoginServlet" method="post">  
<input type="text" placeholder="Username" name="username"><br>  
<input type="password" placeholder="Password"name="password"><br>  
<button type="submit" formmethod="post" value="Login">Login</button>  
<p class="message">Not registered? <a href="Register.jsp">Create an account</a></p><br>
<p class="message"><a href="ForgottenPassword.jsp">Forgot Password?.</a></p>

<%
    if(request.getAttribute("RegisterResult") == "successful"){
%>
 <p style="color:red">You have successfully registered. Please log in now. </p>
<%
}
%>

<%
    if(request.getAttribute("ResetPassword") == "successful"){
%>
 <p style="color:red">New password has been sent by email. </p>
<%

}
%>

<%
    if(request.getAttribute("TempLogging") == "failed"){
%>
 <p style="color:red">Temp Login Failed. Only 3 tries until account is locked. </p>
<%

}
%>
<%
    if(request.getAttribute("TempLogging") == "locked"){
%>
 <p style="color:red">Account is locked. </p>
<%

}
%>




</form>  
 </div>
</div>
<br><br><br>

















</body>
</html>