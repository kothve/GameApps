
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

public class AddInfoProfile extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
		
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		
		
		try{  
			boolean ShowCreditCardInfo = false;
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
			
			
			
			
			
			
			String address1=request.getParameter("userAddress1");							
			String address2=request.getParameter("userAddress2");
			String city=request.getParameter("userCity");
			String state=request.getParameter("userState");
			String zip=request.getParameter("userZip");
			String country=request.getParameter("userCountry");
			
			if(!request.getParameter("userAddress1").isEmpty()){
				
				PreparedStatement s1=con.prepareStatement( "update users set address1='"+address1+"' where username='"+name+"'");  
	    		
	    		 
	    		 s1.executeUpdate();
				
				
			}
			
			if(!request.getParameter("userAddress2").isEmpty()){
				PreparedStatement s2=con.prepareStatement( "update users set address2='"+address2+"' where username='"+name+"'");  
	    		
	    		 
	    		 s2.executeUpdate();
				
				
			}
			
			if(!request.getParameter("userState").isEmpty()){
				
				PreparedStatement s3=con.prepareStatement( "update users set city='"+city+"' where username='"+name+"'");  
	    		
	    		 
	    		 s3.executeUpdate();
				
				
			}
			
			if(!request.getParameter("userState").isEmpty()){
				
				PreparedStatement s4=con.prepareStatement( "update users set state='"+state+"' where username='"+name+"'");  
	    		
	    		 
	    		 s4.executeUpdate();
				
			}
			
			
			if(!request.getParameter("userZip").isEmpty()){
				
				PreparedStatement s5=con.prepareStatement( "update users set zip='"+zip+"' where username='"+name+"'");  
	    		
	    		 
	    		 s5.executeUpdate();
				
				
		
			}
			
			if(!request.getParameter("userCountry").isEmpty()){
				
				PreparedStatement s5=con.prepareStatement( "update users set country='"+country+"' where username='"+name+"'");  
	    		
	    		 
	    		 s5.executeUpdate();
				
				
		
			}
				
				
			
			
			
						
			
			 
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
        
		
		
		
        String creditCard = request.getParameter("creditCard");
        String creditCardNumber = request.getParameter("creditCardNumber");
        String CVV = request.getParameter("creditCardCVV");
        String creditCardExpiration = request.getParameter("creditCardExpiration");
        
        
        
        if(!request.getParameter("creditCard").isEmpty() && !request.getParameter("creditCardCVV").isEmpty() && !request.getParameter("creditCardNumber").isEmpty() 
        		&&  !request.getParameter("creditCardExpiration").isEmpty()){
        	
        	if(CVV.length() != 3 || creditCardNumber.length() != 16 || creditCardExpiration.length() != 4 ){
            	
            	
            	request.setAttribute("CreditCardInfo", "invalid");
            	
            }
        	
        	else{
        	ArrayList userCreditCard = new ArrayList();      
    		PreparedStatement ss=con.prepareStatement( "update users set credit_card_type='"+creditCard+"', credit_card_number='"+creditCardNumber+
    				"', credit_card_cvv='"+CVV +"',credit_card_expiry='"+creditCardExpiration+"' where username='"+name+"'");  
    		
    		 
    		 ss.executeUpdate(); 
    		
    		request.setAttribute("CreditCardInfo", "valid");
        	}
    		
    		
    		 ArrayList userCardInfo = new ArrayList(); 
        	   
    	        
    	        PreparedStatement fs=con.prepareStatement("select credit_card_type, credit_card_number, credit_card_cvv, "
    	        		+ "credit_card_expiry from users where username=?");  
    	        		fs.setString(1,name);  
    	        		 
    	        		ArrayList a2 = null;   
    	        		ResultSet cs=fs.executeQuery();  
    	        		while (cs.next()) {
    	                    a2 = new ArrayList<String>();

//    	                    out.println(rs.getString(1));
//    	                    out.println(rs.getString(2));
//    	                    out.println(rs.getString(3));
//    	                    out.println(rs.getString(4));
    	                    a2.add(cs.getString(1));
    	                    a2.add(cs.getString(2));
    	                    a2.add(cs.getString(3));
    	                    a2.add(cs.getString(4));
    	                    
    	                    

    	                    
    	                    userCardInfo.add(a2);
    	                }
    	        		request.setAttribute("userCardInfo", userCardInfo);
    		
        }
    		
    		
        	//}
            
            
       
        
        //show credit card info
        
        
       
        
		
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