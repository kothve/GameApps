import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Pay extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String name = "";	
		if (session != null) {
			if (session.getAttribute("user") != null) {
				 name = (String) session.getAttribute("user");
				
			} else {
				response.sendRedirect("Index.jsp");
			}
		}
		ArrayList allShoppingCart;
        ArrayList quantityList;
        allShoppingCart = (ArrayList) session.getAttribute("cart");
		
		
		
		LoadGames.purchaseGame(name, allShoppingCart);
         
		
		
		
		
		
        allShoppingCart = null;
         quantityList = null;
		session.setAttribute("cart", allShoppingCart);        
        session.setAttribute("quant", quantityList);
        
        ArrayList gameList = LoadGames.AddGames();
		
		 request.setAttribute("gameList", gameList); 
        
        
        RequestDispatcher view = request.getRequestDispatcher("/Success.jsp");
        view.forward(request, response); 
        
        
        
	
	
		
		
		
		
		
		
		
		
	}

}
