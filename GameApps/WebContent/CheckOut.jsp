
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
                <td><b>TotalPrice</b></td>
                
            </tr>
            <%
                int count1 = 0;
            int total= 0;
                String color1 = "#F9EBB3";
                if (session.getAttribute("cart") != null) {
                    ArrayList al = (ArrayList) session.getAttribute("cart");
                    
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count1 % 2) == 0) {
                            color1 = "#eeffee";
                        }
                        count1++;
                        ArrayList allShoppingCart = (ArrayList) itr.next();
                        
                  if (session.getAttribute("quant") != null) {
                            ArrayList  quantityList = (ArrayList) session.getAttribute("quant");
                            
                                 
                        
                        
                        
                   String price = (String) allShoppingCart.get(1);
                   price = price.substring(0,2);
                   int totalRowPrice = Integer.parseInt(price)*(int)quantityList.get(count1-1);
                   total = total + totalRowPrice;
                       
                        
            %>
            <tr style="background-color:<%=color1%>;">
                <td><%=allShoppingCart.get(0)%></td>
                <td><%=allShoppingCart.get(1)%></td>
                <td><%=quantityList.get(count1-1)%></td>
                <td><%= totalRowPrice%>.00$  </td>                
                
                
                
                
            </tr>
            <%
                    }
                } %>
                    <tr style="background-color:<%=color1%>;">
                    
                      <td>TOTAL = <%=total%>.00$</td> 
                 </tr>
                 <% 
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



<br><br><br>

















<table width="90%" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>Credit Card Info</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Credit Card Type</b></td>
                <td><b>Credit Card Number</b></td>
                <td><b>CVV</b></td>
                <td><b>Expiration date</b></td>
                
            </tr>
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("userCardInfo") != null) {
                    ArrayList a2 = (ArrayList) request.getAttribute("userCardInfo");
                    System.out.println(a2);
                    Iterator itr = a2.iterator();
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
                <td><%=userProfileList.get(2)%></td>
                <td><%=userProfileList.get(3)%></td>
                
                                
                
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
                
                <br><br><br>
                
                
                
               <form method="post" action="Pay">
                <input type="submit" value="Pay"/> </form>
                
                









</body>
</html>