import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//controller

public class EditAddGame extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
		
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		String game_name = request.getParameter("game_Name");
		String description = request.getParameter("description");
		String console = request.getParameter("console");
		int players = Integer.parseInt(request.getParameter("players"));
		String coop = request.getParameter("coop");
		String genre = request.getParameter("genre");
		String year = request.getParameter("year");
		String developer = request.getParameter("developer");
		String publisher = request.getParameter("publisher");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		
		if( AdminCheck.gameExists(game_name)){	
			
			try {
				AdminOperation.updateGames(game_name, console, players, genre, year, developer, publisher, price, discount, quantity, description);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			
			
			ArrayList gameList = LoadGames.AddGames();
			
			 request.setAttribute("gameList", gameList);  
			
			  
	    	RequestDispatcher rd = request.getRequestDispatcher("AdminSuccess.jsp");
	    	rd.forward(request, response);
			
			
			
		}
		
		
		else{
			
			
			
			
			try{
				AdminOperation.insertGames(game_name, console, players, genre, year, developer, publisher, price, discount, quantity, description);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ArrayList gameList = LoadGames.AddGames();
			
			 request.setAttribute("gameList", gameList);  
			
			  
	    	RequestDispatcher rd = request.getRequestDispatcher("AdminSuccess.jsp");
	    	rd.forward(request, response);
			
			
			
			
			
			
			
			
			
			
			
		
		
		}
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	}
	

}
