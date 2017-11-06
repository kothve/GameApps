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
                    <b>User Profile</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>User ID</b></td>
                <td><b>Username</b></td>
                <td><b>Password</b></td>
                <td><b>First Name</b></td>
                <td><b>Last name</b></td>
                <td><b>Email</b></td>
                <td><b>Address 1</b></td>
                <td><b>Address 2</b></td>
                 <td><b>City</b></td>
                 <td><b>State</b></td>
                <td><b>Country</b></td>
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
                <td><%=userProfileList.get(2)%></td>
                <td><%=userProfileList.get(3)%></td>
                <td><%=userProfileList.get(4)%></td>
                <td><%=userProfileList.get(5)%></td>
                <td ><%=userProfileList.get(6)%></td>
                <td ><%=userProfileList.get(7)%></td>
                <td><%=userProfileList.get(8)%></td>
                <td><%=userProfileList.get(9)%></td>
                <td><%=userProfileList.get(10)%></td>
                                
                
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
<%if(request.getAttribute("CreditCardInfo") == "invalid"){ %>

<p style="color:red">Invalid input. Credit card must have 16 numbers and 3 for the cvv. Expiration Date is in the format MMYY</p>

<%} %>    

     <div class="form">
 
     
     
    <form class="login-from" action="AddInfoProfile" method="post">  
	Address1:<input type="text" name="userAddress1"/><br/><br/>  
	Address2:<input type="text" name="userAddress2"/><br/><br/> 
	City:<input type="text" name="userCity"/><br/><br/>  
	State(2 letters):<input type="text" name="userState"/><br/><br/> 
	Zip Code:<input type="text" name="userZip"/><br/><br/>
	Country:<input type="text" name="userCountry"/><br/><br/>
	 
     
     <br>
      <br>
     
     
     
     
        
	  
	Credit Card type:<input type="text" name="creditCard"><br>  
	Credit Card Number:<input type="text" name="creditCardNumber"><br>
	Credit Card CVV:<input type="text" name="creditCardCVV"><br>
	Credit Card Expiration date:<input type="text" name="creditCardExpiration"><br>  
	<button type="submit" formmethod="post" value="AddInfoProfile">Add Credit Card/Edit info</button> 
	</form>  
</div>


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
                int count1 = 0;
                String color1 = "#F9EBB3";
                if (request.getAttribute("userCardInfo") != null) {
                    ArrayList a2 = (ArrayList) request.getAttribute("userCardInfo");
                    System.out.println(a2);
                    Iterator itr = a2.iterator();
                    while (itr.hasNext()) {
 
                        if ((count1 % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList userProfileList = (ArrayList) itr.next();
            %>
            <tr style="background-color:<%=color1%>;">
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
        <br><br><br><br>
        
       
    
    
    
    
    <div class="header-right"><form  class="form" action="LogoutServlet" method="post"> <button type="submit" formmethod="post" value="Logout">
    Logout
    </button></form>












</body>
</html>