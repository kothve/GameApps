import java.io.*;  
import javax.servlet.*;
import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
  
//Olivier Mercier-Peetz 27181000
//LOGIN CONTROLLER


public class LoginServlet extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
	
	
	
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String username = request.getParameter("username");  
    String password =request.getParameter("password");  
    RequestDispatcher rd = null;      
    
    if(Login.validate(username, password)){  //uthentication
    	
    	//display all the database items
    	try{  
    		
    		String url = "jdbc:mysql://localhost/soen387";
    		String username1 = "o_mercie";
    		String password1 = "odette";
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		
    		
    	Connection con=DriverManager.getConnection(url,username1,password1); 
    	
    	
    	String statement = "select games_id, game_name, console, price from games";
    	PreparedStatement ps=con.prepareStatement(statement);
    	
    	 ResultSet rs=ps.executeQuery();
    	 
    	 
    	 ArrayList al = null;
         
         ArrayList gameList = new ArrayList();
         
         
         while (rs.next()) {
             al = new ArrayList<String>();
            

//             out.println(rs.getString(1));
//             out.println(rs.getString(2));
//             out.println(rs.getString(3));
//             out.println(rs.getString(4));
             al.add(rs.getString(1));
             al.add(rs.getString(2));
             al.add(rs.getString(3));
             al.add(rs.getString(4));
             
             
             gameList.add(al);
             
         }
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	
    	HttpSession session = request.getSession(true);
    	
    	
    	rd = request.getRequestDispatcher("Success.jsp");
    	 request.setAttribute("gameList", gameList);  	
    	session.setAttribute("user", username);
    	
    	session.setMaxInactiveInterval(1000);   
    	rd = request.getRequestDispatcher("Success.jsp");
    	 rd.forward(request, response);
    	//response.sendRedirect("Success.jsp");
    	 con.close();
        
    }catch(Exception e){System.out.println(e); }    }
    	 	
    	
    else{  
    	
        out.print("<p style=\"color:red\"> Login Failed. Please try again. </p>");  
         rd = request.getRequestDispatcher("Login.jsp");  
        rd.include(request, response);
    }  
         
    out.close(); 
   
    }  
}  