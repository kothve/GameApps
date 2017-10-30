<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In Success</title>
</head>
<body>

<a href="Specials">Specials</a>|  ||
<a href="ProfileServlet">Profile</a>  ||
<form action="LogoutServlet" method="post">
		<input type="submit" value="Logout">
	</form>
<br><br>


<%
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String name = (String) session.getAttribute("user");
				out.print("Hello, " + name + "  welcome");
			} else {
				response.sendRedirect("Loging.jsp");
			}
		}
	%>
<br><br><br>
<form method="post" action="Search">
      
Game ID:<input type="text" name="game_Id"/> ||  
Game Name:<input type="text" name="game_Name"/> <br/><br/>
Console :<input type="text" name="console"/>||
Genre:<input type="text" name="genre"/><br/><br/> 
Year of release:<input type="text" name="year"/>|| 
Developer:<input type="text" name="developer"/>||  
Publisher:<input type="text" name="publisher"/>|| 



<br/><br/>  
<input type="submit" value="Search"/>        
      
    </form>	
	
	
<br><br><br>	
	
<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>Game Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Game ID</b></td>
                <td><b>Game Name</b></td>             
                <td><b>Console</b></td>               
                 <td><b>Price</b></td>
                
            </tr>
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("gameList") != null) {
                    ArrayList al = (ArrayList) request.getAttribute("gameList");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList gameList = (ArrayList) itr.next();
            %>
            <tr style="background-color:<%=color%>;">
                <td><%=gameList.get(0)%></td>
                <td><%=gameList.get(1)%></td>
                <td><%=gameList.get(2)%></td>               
                <td><%=gameList.get(3)%></td>
                
                
                
                
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