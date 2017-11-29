import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCart extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//default quantity
		
    	
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        ArrayList allShoppingCart;
        ArrayList quantityList;
        allShoppingCart = (ArrayList) session.getAttribute("cart");
        quantityList = (ArrayList) session.getAttribute("quantityList");
        
        if(allShoppingCart == null){
            allShoppingCart = new ArrayList();
            session.setAttribute("cart", allShoppingCart);
            quantityList = new ArrayList();
            session.setAttribute("quantityList", quantityList);
          }
        
         
        
        
        String name = request.getParameter("game_name");
        String price = request.getParameter("price");
        
        int quantity = Integer.parseInt(request.getParameter("initialQuantity"));
        
        
        quantityList.add(quantity);
                 
        
        
        ArrayList<String> item =  new ArrayList<String>();  
        item.add(name);
        item.add(price);
        
        
            
        
        allShoppingCart.add(item);
              
        
        session.setAttribute("cart", allShoppingCart);        
        session.setAttribute("quant", quantityList);
        
        RequestDispatcher view = request.getRequestDispatcher("/Cart.jsp");
        view.forward(request, response); 
	    
        
        
         
             
        }
    }