import java.io.*;  
import javax.servlet.*;
import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

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
    
  //testing
	
	
    
    if (IncrementLogging.isLocked(username)){
    	
    	
    	request.setAttribute("TempLogging", "locked"); 
		 rd = request.getRequestDispatcher("Login.jsp");  
	       rd.include(request, response);
    	
    	
    	
    	
    }
    
    
    
	
	//
    
    else if(LoginTemp.exist(username)){
    
    	
    	
    	if(LoginTemp.validate(username, password)){
    		
    		
    		ArrayList gameList = LoadGames.AddGames();	
    		
    		HttpSession session = request.getSession(true);
        	
        	
        	AdminCheck.addLogin(username);
        	 request.setAttribute("gameList", gameList);  	
        	session.setAttribute("user", username);
        	
        	session.setMaxInactiveInterval(1000);   
        	rd = request.getRequestDispatcher("Success.jsp");
        	 rd.forward(request, response);
    		
    		
    		
    		
    		
    	}//end if loginTemp 	
    	
    	else if(IncrementLogging.getNumberOfAttempts(username) >= 3){
    		
    		IncrementLogging.Lock(username);
    		request.setAttribute("TempLogging", "locked"); 
    		 rd = request.getRequestDispatcher("Login.jsp");  
    	       rd.include(request, response);
    		
    	}
    	
    	
    	
    	else if(IncrementLogging.getNumberOfAttempts(username) <3 ) {
    	
    	IncrementLogging.Increment(username);
    		
    	request.setAttribute("TempLogging", "failed");  
    	 
    	
       rd = request.getRequestDispatcher("Login.jsp");  
       rd.include(request, response);
       
       
    	}//end else
    	
    }//end if reset
    
    
    
    
   
    
    
    	
    	 	
    	else if(Login.validate(username, password)){  //uthentication
    	
    		
    		if(AdminCheck.AdminCheck(username)){
    			
    			
    			HttpSession session = request.getSession(true);
    			ArrayList gameList = LoadGames.AddGames();
    			
    			 request.setAttribute("gameList", gameList);  
    			session.setAttribute("user", username);
    			session.setMaxInactiveInterval(1000);   
    	    	rd = request.getRequestDispatcher("AdminSuccess.jsp");
    	    	 rd.forward(request, response);
    			
    			
    			
    		}
    		
    		else{	
    	 ArrayList gameList = LoadGames.AddGames();
    	 
    	 
    	 
    	
    	HttpSession session = request.getSession(true);
    	
    	AdminCheck.addLogin(username);
    	rd = request.getRequestDispatcher("Success.jsp");
    	 request.setAttribute("gameList", gameList);  	
    	session.setAttribute("user", username);
    	
    	session.setMaxInactiveInterval(1000);   
    	rd = request.getRequestDispatcher("Success.jsp");
    	 rd.forward(request, response);
    	//response.sendRedirect("Success.jsp");
    		}
        
    }    
    	 	
    	
    else{  
    	
        out.print("<p style=\"color:red\"> Login Failed. Please try again. </p>");  
         rd = request.getRequestDispatcher("Login.jsp");  
        rd.include(request, response);
    }  
         
    out.close(); 
   
    }  
}  