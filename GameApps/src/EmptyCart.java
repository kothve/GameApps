import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmptyCart extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//default quantity
		
		HttpSession session = request.getSession();
		ArrayList allShoppingCart = null;
        ArrayList quantityList = null;
		session.setAttribute("cart", allShoppingCart);        
        session.setAttribute("quant", quantityList);
		
    	
        
        RequestDispatcher view = request.getRequestDispatcher("/Cart.jsp");
        view.forward(request, response); 
	    
        
        
         
             
        }
    }