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

public class Inventory extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
		
		
		ArrayList gameList = new ArrayList();
		ArrayList quantity = new ArrayList();
		
		
		
		
		gameList = LoadGames.ShowInventory();
		quantity = LoadGames.Quantity();
		
		request.setAttribute("gameList", gameList);
		request.setAttribute("quantity", quantity);
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/Inventory.jsp");
		view.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
	}