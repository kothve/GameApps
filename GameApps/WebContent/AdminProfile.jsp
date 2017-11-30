<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/style.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#left
{
  float: left;
  
  width: 50%;
}

#right
{
  float: right;
  width: 50%;
}



</style>




</head>
<body>


<table width="90%" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=11 align="center"
                    style="background-color:teal">
                    <b>Admin Profile</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>User ID</b></td>
                <td><b>Username</b></td>
                
            </tr>
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("userProfileList") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("userProfileList");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList userProfileList = (ArrayList) itr.next();
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=userProfileList.get(0)%></td>
                <td><%=userProfileList.get(1)%></td>
                
                                
                
            </tr>
            <%
                    }
                }
                if (count == 0) {
            %>
            <tr>
                <td colspan=4 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>
        </table>
        <br>
        <br>


     <div class="form">
 
     
     
    <form class="login-from" action="UserInfo" method="post">  
    Username <input type="text" name="username"/><br>
   
    
	
	<button type="submit" formmethod="post" value="UserInfo">Get User info</button> 
	</form>  
</div>
<table width="90%" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=11 align="center"
                    style="background-color:teal">
                    <b>LOGIN HISTORY</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Username</b></td>
                <td><b>Last Login</b></td>
                
            </tr>
            <%
                int count1 = 0;
                String color1 = "#F9EBB3";
                if (request.getAttribute("LoginDate") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("LoginDate");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count1++;
                        ArrayList userProfileList = (ArrayList) itr.next();
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=userProfileList.get(0)%></td>
                <td><%=userProfileList.get(1)%></td>
                
                                
                
            </tr>
            <%
                    }
                }
                if (count1 == 0) {
            %>
            <tr>
                <td colspan=4 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>
        </table>
        
        <table width="90%" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=11 align="center"
                    style="background-color:teal">
                    <b>Purchase History</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Username</b></td>
                <td><b>Game Name</b></td>
                
            </tr>
            <%
                int count2 = 0;
                String color2 = "#F9EBB3";
                if (request.getAttribute("Purchase") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("Purchase");
                    
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count2 % 2) == 0) {
                            color2 = "#eeffee";
                        }
                        count2++;
                        ArrayList userProfileList = (ArrayList) itr.next();
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=userProfileList.get(0)%></td>
                <td><%=userProfileList.get(1)%></td>
                
                                
                
            </tr>
            <%
                    }
                }
                if (count2 == 0) {
            %>
            <tr>
                <td colspan=4 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>
        </table>






   <div class="form">
 
     
    

        
        
        
        
        <br>
        <br> 
     
     
     
     
     
     
     
     
    <form class="login-from" action="blockUser" method="post">  
    Block Username <input type="text" name="blockusername"/><br>  
    Unblock Username <input type="text" name="unblockusername"/><br>  
       	
	<button type="submit" formmethod="post" value="blockUser">Block/Unblock User</button> 
	</form>  
</div>
     <br><br>
     
     <%
    if(request.getAttribute("Locked") == "yes"){
%>
 <p style="color:red">You have successfully locked user. </p>
<%
}
%>  
    <%
     if(request.getAttribute("Locked") == "no"){
%>
 <p style="color:red">You have successfully unlocked user. </p>
<%
}
%>  
    
    
    
    <div class="header-right"><form  class="form" action="LogoutServlet" method="post"> <button type="submit" formmethod="post" value="Logout">
    Logout
    </button></form>












</body>
</html>