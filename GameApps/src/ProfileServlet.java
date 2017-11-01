
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

public class ProfileServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
		
		try{  
			
			boolean ShowCreditCardInfo = false;
			 response.setContentType("text/html");  
		         
			 PrintWriter out = response.getWriter();
		
			HttpSession session = request.getSession(false);  
	        if (session != null) {
				if (session.getAttribute("user") != null) {
					String name = (String) session.getAttribute("user");
					out.print("Hello, " + name + "  welcome");
				} else {
					response.sendRedirect("Index.jsp");
				}
			}
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			 String name = (String) session.getAttribute("user");
			
		Connection con=DriverManager.getConnection(url,username,password); 
		ArrayList userProfileList = new ArrayList();      
		PreparedStatement ps=con.prepareStatement(  
		"select * from users where username=?");  
		ps.setString(1,name);  
		 
		ArrayList al = null;   
		ResultSet rs=ps.executeQuery();  
		while (rs.next()) {
            al = new ArrayList<String>();

//            out.println(rs.getString(1));
//            out.println(rs.getString(2));
//            out.println(rs.getString(3));
//            out.println(rs.getString(4));
            al.add(rs.getString(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getString(4));
            al.add(rs.getString(5));
            al.add(rs.getString(6));
            al.add(rs.getString(7));
            al.add(rs.getString(8));
            al.add(rs.getString(9));
            al.add(rs.getString(10));
            al.add(rs.getString(11));
            

            
            userProfileList.add(al);
        }
        
   
                request.setAttribute("userProfileList", userProfileList);
                RequestDispatcher view = request.getRequestDispatcher("/Profile.jsp");
                view.forward(request, response); 
       	
       	
        	
        
        
        
        
        
        
        
        
         
       out.close();
        con.close();
        System.out.println("Disconnected!");
       
		}
		catch (Exception e) {
            e.printStackTrace();
        }  
    }  
}  