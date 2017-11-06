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
</head>
<body>
<h1> REGISTRATION </h1>
<%
    if(request.getAttribute("RegisterResult") == "empty" ){
%>
 <p style="color:red"> Registering Failed. Please try again. Please make sure to fill out Username, Password, FirstName, LastName and Email. </p>

<%
}


%>
<%
    if(request.getAttribute("RegisterResult") == "false" ){
%>
 <p style="color:red">Username is already taken. Please try again. </p>
<% } %>

<%
    if (request.getAttribute("RegisterResult") == "emailError" ){
%>
 <p style="color:red">Email has the wrong format. Please try again. </p>
<% } %>

<br><br><br><br>

  <div class="form">
<form class="login-from" action="Register" method="post">  
<input type="text" placeholder="Username" name="userName"/><br/> 
<input type="password" placeholder="Password" name="userPass"/><br/>    
<input type="text" placeholder="First Name" name="userFirstName"/><br/> 
<input type="text" placeholder="Last Name" name="userLastName"/><br/>  
<input type="text" placeholder="Email" name="userEmail"/><br/>  
<input type="text" placeholder="Address 1" name="userAddress1"/><br/><br/>  
<input type="text" placeholder="Address 2" name="userAddress2"/><br/><br/> 
<input type="text" placeholder="City name" name="userCity"/><br/><br/>  
<input type="text" placeholder="State"  name="userState"/><br/><br/> 
<input type="text" placeholder="Zip Code" name="userZip"/><br/><br/>
<input type="text"  placeholder="Country" name="userCountry"/><br/><br/>
<br/>    
<button type="submit"  value="Register">Register</button>    
</form> 
</div>

  




</body>
</html>