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
<header>
    <div class="header-left"><a href="Specials"><img border="0" alt="sales" src="<%=request.getContextPath()%>/images/sales.jpeg" width="100" height="100"></a> </div>
    
    
    
    <div class="header-center">
        <form class="form"  action="ProfileServlet" method="post"><button type="submit" formmethod="post" value="Profile">See Profile</button></form>
    </div>
    <div class="header-right"><form  class="form" action="LogoutServlet" method="post"> <button type="submit" formmethod="post" value="Logout">
    Logout
    </button></form></div>




</header>

<table width="100%" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>Shopping Cart</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Game Name</b></td>
                <td><b>Price</b></td>
                <td><b>Quantity</b></td>
                <td><b>New Quantity</b></td>
                
            </tr>
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (session.getAttribute("cart") != null) {
                    ArrayList al = (ArrayList) session.getAttribute("cart");
                    
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList allShoppingCart = (ArrayList) itr.next();
                        
                  if (session.getAttribute("quant") != null) {
                            ArrayList  quantityList = (ArrayList) session.getAttribute("quant");
                            
                                 
                        
                        
                        
                        
                        
                        
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=allShoppingCart.get(0)%></td>
                <td><%=allShoppingCart.get(1)%></td>
                <td><%=quantityList.get(count-1)%></td>
                <td><form method="post" action="ChangeQuantity"> <input type="text" name="quantity"><input type="hidden" name="index" value="<%=count-1%>"/>
                <input type="submit" value="Change Quantity"/> </form> </td>                
                
                
                
                
            </tr>
            <%
                    }
                }}
                    
                if (count == 0) {
            %>
            <tr>
                <td colspan=4 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>
        </table>

<form method="post" action="EmptyCart">
                <input type="submit" value="Empty Shopping Cart"/> </form>
                <br><br><br>
                <form method="post" action="CheckOut">
                <input type="submit" value="CheckOut"/> </form>


</body>
</html>