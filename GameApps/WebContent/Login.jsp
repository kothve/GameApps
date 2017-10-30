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
    if(request.getAttribute("RegisterResult") == "successful"){
%>
 <p style="color:red">You have successfully registered. Please log in now. </p>
<%
}
%>


<br><br>

<h1>GAME APPS</h1>  





<form action="LoginServlet" method="post">  
Username:<input type="text" name="username"><br>  
Password:<input type="password" name="password"><br>  
<input type="submit" value="login">  
</form>  
<br><br><br>


<a href="Register.jsp">Register</a> 














</body>
</html>