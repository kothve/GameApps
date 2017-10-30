<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    if(request.getAttribute("RegisterResult") == "empty" ){
%>
 <p style="color:red"> Registering Failed. Please try again. Please make sure to fill out the fields in red. </p>

<br><br>

<form action="Register" method="post">  
<p style="color:red">Username :<input type="text" name="userName"/>		<br/><br/> 
Password:<input type="password" name="userPass"/>		<br/><br/>     
First Name:<input type="text" name="userFirstName"/>		<br/><br/>  
Last Name:<input type="text" name="userLastName"/>		<br/><br/>  
Email:</p><input type="text" name="userEmail"/>		<br/><br/>  
Address1:<input type="text" name="userAddress1"/>		<br/><br/>  
Address2:<input type="text" name="userAddress2"/>		<br/><br/> 
City:<input type="text" name="userCity"/>		<br/><br/>  
State(2 letters):<input type="text" name="userState"/><br/><br/> 
Zip Code:<input type="text" name="userZip"/><br/><br/>
Country:<input type="text" name="userCountry"/><br/><br/>
<br/><br/>  
<input type="submit" value="Register"/>  
  
</form> 

<%
}

else {
%>
<%
    if(request.getAttribute("RegisterResult") == "false" ){
%>
 <p style="color:red">Username is already taken. Please try again. </p>
<% } %>

<br><br>

<form action="Register" method="post">  
Username :<input type="text" name="userName"/><br/><br/> 
Password:<input type="password" name="userPass"/><br/><br/>     
First Name:<input type="text" name="userFirstName"/><br/><br/>  
Last Name:<input type="text" name="userLastName"/><br/><br/>  
Email:<input type="text" name="userEmail"/><br/><br/>  
Address1:<input type="text" name="userAddress1"/><br/><br/>  
Address2:<input type="text" name="userAddress2"/><br/><br/> 
City:<input type="text" name="userCity"/><br/><br/>  
State(2 letters):<input type="text" name="userState"/><br/><br/> 
Zip Code:<input type="text" name="userZip"/><br/><br/>
Country:<input type="text" name="userCountry"/><br/><br/>
<br/><br/>  
<input type="submit" value="Register"/>  
  
</form> 

<%
}
%>  
  




</body>
</html>