<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
                <td><b>Description</b></td>
                <td><b>Console</b></td>
                <td><b>Players</b></td>
                <td><b>COOP</b></td>
                <td><b>Genre</b></td>
                <td><b>Release date</b></td>
                <td><b>Developer</b></td>
                 <td><b>Publisher</b></td>
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
                 <td><%=request.getAttribute("gameInt") %></td>
                <td><%=gameList.get(4)%></td>
                
                <td><%=gameList.get(5)%></td>
                <td><%=gameList.get(6)%></td>
                <td><%=gameList.get(7)%></td>
                <td><%=gameList.get(8)%></td>
                <td><%=gameList.get(9)%></td>
                
                
                
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