import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IncrementLogging {
	
	static int AttemptNumber;
	public static int getNumberOfAttempts(String name){
		
		
		
try{  
			
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password); 	
		
			
		      
			PreparedStatement ps=con.prepareStatement(  
			"Select * from users where username=?");  
			ps.setString(1,name);  
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			AttemptNumber = rs.getInt(22);
			
				
	
	}catch(Exception e){System.out.println(e);}
return AttemptNumber;  }

	public static void Increment(String name){
		
		try{  
			
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password); 	
			
			int tries = 0;
					
					tries = IncrementLogging.getNumberOfAttempts(name); 
			tries++;
						
			
		PreparedStatement ps=con.prepareStatement("UPDATE soen387.users SET logging_attempt='"+tries+"' WHERE username='"+name+"'");  
			  
			  
		      
			ps.executeUpdate();
		      
		
		          
		}catch(Exception e){System.out.println(e);}  
		
		}  

		
public static void Lock(String name){
	
	try{  
		
		String url = "jdbc:mysql://localhost/soen387";
		String username = "o_mercie";
		String password = "odette";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection(url,username,password); 	
		
	
		String yes = "YES";	

PreparedStatement r1=con.prepareStatement( "update users set locked='"+yes+"' where username='"+name+"'");;  
				
		
	/*PreparedStatement r1=con.prepareStatement("UPDATE soen387.users SET lock='yes' WHERE username='"+name+"'");  */
		  
	
	      
		r1.executeUpdate();
	      
	
	          
	}catch(Exception e){System.out.println(e);}  
	
	} 
		
		
}
		
