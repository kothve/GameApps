import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserEmailValidation {
	
	
	public static boolean EmailUservalidate(String name,String email){  
		boolean status=false;  
		try{  
			
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
		Connection con=DriverManager.getConnection(url,username,password); 
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from users where username=? and email=?");  
		ps.setString(1,name);  
		ps.setString(2,email);  
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		 con.close();          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}  
		
		
		
		
		
		
	}
	
	
	
	


