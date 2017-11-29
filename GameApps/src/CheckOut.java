import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckOut extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//default quantity
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("user");
		int count =0;
		ArrayList price =  new ArrayList();
		ArrayList rowTotal =  new ArrayList();
        
		
		
		String url = "jdbc:mysql://localhost/soen387";
		String username = "o_mercie";
		String password = "odette";
		
		 ArrayList  quantityList = (ArrayList) session.getAttribute("quant");
		
		
		if (session.getAttribute("cart") != null) {
            ArrayList al = (ArrayList) session.getAttribute("cart");
            
            
            Iterator itr = al.iterator();
            while (itr.hasNext()) {

               
                count++;
                ArrayList allShoppingCart = (ArrayList) itr.next();
                
                String price1 = (String) allShoppingCart.get(1);
                price1 = price1.substring(0,2);
                int result = Integer.parseInt(price1);
                price.add(result);
                
                
                
                
                
          
                    
            }         
		}    
		
		
		session.setAttribute("priceList", price);
		
		
		try{
		
	Connection con=DriverManager.getConnection(url,username,password); 
		
		
		
		
		
		
		 ArrayList userCardInfo = new ArrayList(); 
  	   
	        
	        PreparedStatement fs=con.prepareStatement("select credit_card_type, credit_card_number, credit_card_cvv, "
	        		+ "credit_card_expiry from users where username=?");  
	        		fs.setString(1,name);  
	        		 
	        		ArrayList a2 = null;   
	        		ResultSet cs=fs.executeQuery();  
	        		while (cs.next()) {
	                    a2 = new ArrayList<String>();

//	                    out.println(rs.getString(1));
//	                    out.println(rs.getString(2));
//	                    out.println(rs.getString(3));
//	                    out.println(rs.getString(4));
	                    a2.add(cs.getString(1));
	                    a2.add(cs.getString(2));
	                    a2.add(cs.getString(3));
	                    a2.add(cs.getString(4));
	                    
	                    

	                    
	                    userCardInfo.add(a2);
	                }
	        		request.setAttribute("userCardInfo", userCardInfo);
		
		
		
		
    	
        
        RequestDispatcher view = request.getRequestDispatcher("/CheckOut.jsp");
        view.forward(request, response); 
	    
		}
		catch (Exception e) {
            e.printStackTrace();
        }  
        
         
             
        }
    }