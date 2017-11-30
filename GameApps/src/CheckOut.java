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
		String name = "";	
		if (session != null) {
			if (session.getAttribute("user") != null) {
				 name = (String) session.getAttribute("user");
				
			} else {
				response.sendRedirect("Index.jsp");
			}
		}
		
		
		try{
	
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";	
			
	Connection con=DriverManager.getConnection(url,username,password); 
		
		
		
		
		
		
	 ArrayList userCardInfo = new ArrayList(); 
	   
     
     PreparedStatement fs=con.prepareStatement("select credit_card_type, credit_card_number, credit_card_cvv, "
     		+ "credit_card_expiry from users where username=?");  
     		fs.setString(1,name);  
     		 
     		ArrayList a2 = null;   
     		ResultSet cs=fs.executeQuery();  
     		while (cs.next()) {
                 a2 = new ArrayList<String>();

//                 out.println(rs.getString(1));
//                 out.println(rs.getString(2));
//                 out.println(rs.getString(3));
//                 out.println(rs.getString(4));
                 a2.add(cs.getString(1));
                 a2.add(cs.getString(2));
                 a2.add(cs.getString(3));
                 a2.add(cs.getString(4));
                 
                 

                 
                 userCardInfo.add(a2);
            
     		
		}
     		request.setAttribute("userCardInfo", userCardInfo);
     		con.close();
        }catch (Exception e) {
            e.printStackTrace();}  
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/CheckOut.jsp");
        view.forward(request, response); 
         
             
        }
    }