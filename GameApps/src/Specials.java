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

public class Specials extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
       
        Connection conn = null;
        String url = "jdbc:mysql://localhost/soen387";
    	String username = "o_mercie";
    	String password = "odette";
    	
    	int gameInt = 1;
    	
    	
    	
    
 
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection(url,username,password); 
            //System.out.println("Connected!");
            
        	
        	
        	
        	
            ArrayList al = null;
            ArrayList specialList = new ArrayList();
	
	 
         
         PreparedStatement ps=con.prepareStatement("select * from games where NOT discount = '0'");
         
         
         
         
     
     ResultSet rs=ps.executeQuery();
         
         
         
         while (rs.next()) {
             al = new ArrayList<String>();

//             out.println(rs.getString(1));
//             out.println(rs.getString(2));
//             out.println(rs.getString(3));
//             out.println(rs.getString(4));
             al.add(rs.getString(1));
             al.add(rs.getString(2));
             al.add(rs.getString(3));
             al.add(rs.getString(4));
             gameInt = rs.getInt(5);
             al.add(rs.getString(6));
             al.add(rs.getString(7));
             al.add(rs.getString(8));
             al.add(rs.getString(9));
             al.add(rs.getString(10));
             
             al.add(rs.getString(12));

             
             specialList.add(al);
         }
         
         request.setAttribute("specialList", specialList);
         request.setAttribute("gameInt", gameInt);
         RequestDispatcher view = request.getRequestDispatcher("/Specials.jsp");
         view.forward(request, response);
         con.close();
         }
        catch (Exception e) {
            e.printStackTrace();
        }    
	 
	
	
}
         
        
        
        
  
        
        
}
