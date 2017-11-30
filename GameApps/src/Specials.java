import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Specials extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
       
        String name = null;
        
        HttpSession session = request.getSession(false);  
        if (session != null) {
 			if (session.getAttribute("user") != null) {
 				 name = (String) session.getAttribute("user");
 				
 			} else {
 				response.sendRedirect("Index.jsp");
 			}
 		}
        
        
        
        
        
        
        
        if(AdminCheck.AdminCheck(name)){
        	
        	
        	
        	ArrayList specialList = LoadGames.SpecialGames();
            
        	
            
            request.setAttribute("specialList", specialList);
            request.setAttribute("gameInt", 3);
            RequestDispatcher view = request.getRequestDispatcher("/AdminSpecials.jsp");
            view.forward(request, response);
        	
        	
        	
        	
        	
        	
        	
        	
        }
        
        
        
        
        else{
        
         
        ArrayList specialList = LoadGames.SpecialGames();
        
        	
         
         request.setAttribute("specialList", specialList);
         request.setAttribute("gameInt", 3);
         RequestDispatcher view = request.getRequestDispatcher("/Specials.jsp");
         view.forward(request, response);
         
         }
        
	 
	
	
}
         
        
        
	}  
  
        
        

