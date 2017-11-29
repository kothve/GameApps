import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeQuantity extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//default quantity
		
    	
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        ArrayList quantityList;
      
        quantityList = (ArrayList) session.getAttribute("quantityList");
        
        
        
        ArrayList Qitem =  new ArrayList();  
        
        
        
        int index = Integer.parseInt(request.getParameter("index"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        
        quantityList.set(index, quantity);
        
                 
        
       
        
        
                   
        
                
        session.setAttribute("quant", quantityList);
        
        RequestDispatcher view = request.getRequestDispatcher("/Cart.jsp");
        view.forward(request, response); 
	    
        
        
         
             
        }
    }