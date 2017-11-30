<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>   
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/style.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In Success</title>
<style>

header{
    /* Enable flex mode. */
    display: flex; 

    /* Spread out the elements inside the header. */
    justify-content: space-between;

    /* Align items vertically in the center. */
    align-items: center;
    }
    #left
{
  float: left;
  
  width: 30%;
}

#right
{
  float: right;
  width: 70%;
}






</style>

</head>
<body>
<header>
    <div class="header-left"><a href="Specials"><img border="0" alt="sales" src="<%=request.getContextPath()%>/images/sales.jpeg" width="100" height="100"></a> </div>
    
    <div class="header-center">
        <form class="form"  action="Inventory" method="post"><button type="submit" formmethod="post" value="Invetory">Inventory</button></form>
    </div>
    
    <div class="header-center">
        <form class="form"  action="ProfileServlet" method="post"><button type="submit" formmethod="post" value="Profile">Admin Panel</button></form>
    </div>
    <div class="header-right"><form  class="form" action="LogoutServlet" method="post"> <button type="submit" formmethod="post" value="Logout">
    Logout
    </button></form></div>




</header>







	
<table id="right" width="100%" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>All Games</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Game Name</b></td>
                <td><b>Quantity</b></td>             
                
                
            </tr>
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("gameList") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("gameList");
                    ArrayList a2 = (ArrayList) request.getAttribute("quantity");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    Iterator itr2 = a2.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList gameList = (ArrayList) itr.next();
                        ArrayList quantity = (ArrayList) itr2.next();
            %>
            <tr style="background-color:<%=color%>;">           
            	
                <td><%=gameList.get(0)%></td>
                <td><%=quantity.get(0)%></td>               
                
                
                
                
                
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
	







</body>
</html>