import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Register extends HttpServlet {
	
	private static EmailValidator emailValidator;
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//connection info
		String url = "jdbc:mysql://localhost/soen387";
		String username1 = "o_mercie";
		String password1 = "odette";
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName=request.getParameter("userFirstName");
		String lastName=request.getParameter("userLastName");
		String username=request.getParameter("userName");
		String password=request.getParameter("userPass");
		String email=request.getParameter("userEmail");
		
		String address1=request.getParameter("userAddress1");							
		String address2=request.getParameter("userAddress2");
		String city=request.getParameter("userCity");
		String state=request.getParameter("userState");
		String zip=request.getParameter("userZip");
		String country=request.getParameter("userCountry");
		
		//register as N\A if field is empty
		
		if(request.getParameter("userAddress1").isEmpty()){
			address1 = "N/A";		
			
		}
		
		if(request.getParameter("userAddress2").isEmpty()){
			address2 = "N/A";		
			
		}
		
		if(request.getParameter("userCity").isEmpty()){
			city = "N/A";		
			
		}

		
		
		
		if(request.getParameter("userState").isEmpty()){
			state = "N/A";		
			
		}
		
		if(request.getParameter("userZip").isEmpty()){
			zip = "N/A";		
			
		}
		
		
		if(request.getParameter("userCountry").isEmpty()){
			country = "N/A";		
			
		}
		
		
		if(!request.getParameter("userFirstName").isEmpty() && !request.getParameter("userLastName").isEmpty() && !request.getParameter("userName").isEmpty() && !request.getParameter("userPass").isEmpty() && !request.getParameter("userEmail").isEmpty()){
			
			
			
			 emailValidator = new EmailValidator();
		
		try{
			
			if (Login.validate(username, password) ){
				
				request.setAttribute("RegisterResult", "false"); 
				 RequestDispatcher view = request.getRequestDispatcher("/Register.jsp");
			        view.forward(request, response);
				
				
				
			}
			
			else if(!EmailValidator.validateEmail(email)){
				
				
				
				request.setAttribute("RegisterResult", "emailError"); 
				 RequestDispatcher view = request.getRequestDispatcher("/Register.jsp");
			        view.forward(request, response);
				
				
				
				
				
			}
			
			
			
			else{
			
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
		
		
		
		Connection con=DriverManager.getConnection(url,username1,password1);
		PreparedStatement ps=con.prepareStatement("insert into users(username, password, firstname, lastname, email, address1, address2, city, state, zip, country)  values(?, ?, ?,?, ?,?,?,?,?,?,?)");
		
		ps.setString(1,username);
		ps.setString(2,password);
		ps.setString(3,firstName);
		ps.setString(4,lastName);
		ps.setString(5,email);
		ps.setString(6,address1);
		ps.setString(7,address2);
		ps.setString(8,city);
		ps.setString(9,state);
		ps.setString(10,zip);
		ps.setString(11,country);
		
		
		
		
		
		int i=ps.executeUpdate();
		
		
		
		
		
		request.setAttribute("RegisterResult", "successful"); 
		RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
        view.forward(request, response); 
        con.close();}
        
		}
		catch (Exception e2) {System.out.println(e2);}
		
		out.close();
		
		
		}
		
		else{
			
			request.setAttribute("RegisterResult", "empty"); 
			 RequestDispatcher view = request.getRequestDispatcher("/Register.jsp");
		        view.forward(request, response);
			
			
			
		}
		
		
		
		}
	}


