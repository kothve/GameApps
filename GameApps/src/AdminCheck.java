import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;





public class AdminCheck {
	public static boolean AdminCheck(String name){  
		boolean status=false;  
		try{  
			
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
		Connection con=DriverManager.getConnection(url,username,password); 
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from users where username=? and type='admin'");  
		ps.setString(1,name);  
		
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		 con.close();          
		}catch(Exception e){System.out.println(e);}  
		return status;  
}
	
	
	public static boolean gameExists(String name){  
		boolean status=false;  
		try{  
			
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
		Connection con=DriverManager.getConnection(url,username,password); 
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from games where game_name=?");  
		ps.setString(1,name);  
		
		      
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		 con.close();          
		}catch(Exception e){System.out.println(e);}  
		return status;  
}
	
	public static void addLogin(String name){
		
		
try{  
			
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			

			String formatted = format1.format(cal.getTime());
			
			
			
			
			java.sql.Date.valueOf(formatted);
			
			
			
			
			
		Connection con=DriverManager.getConnection(url,username,password); 
		      
		
		
		
		
		
		
		PreparedStatement ps=con.prepareStatement(  
				"UPDATE `users` SET  `last_login`=? where `username`=?");  
		ps.setString(1,formatted);  
		ps.setString(2,name);
		
		      
		ps.executeUpdate(); 
	
		
		      
	
		
		 con.close();          
		}catch(Exception e){System.out.println(e);}  
		
		
		
		
		
		
		
	}
	
	
	public static String getLastLogin(String name){
		String lastLogin = " ";
		
		try{  
					
					String url = "jdbc:mysql://localhost/soen387";
					String username = "o_mercie";
					String password = "odette";
					
					Class.forName("com.mysql.jdbc.Driver");
					
					
					
					
					
					
				Connection con=DriverManager.getConnection(url,username,password); 
				      
				
				
				
				
				
				
				PreparedStatement ps=con.prepareStatement(  
						"SELECT `last_login` FROM  `users` where `username`=?");  
				 
				ps.setString(1,name);
				
				Date login = null;    			  
				
				ResultSet rs = ps.executeQuery();  
				
				while(rs.next()) {
					 login = rs.getDate("last_login");
				}
				
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				
				lastLogin = df.format(login);
				
				
				
				
				
				con.close(); 
				
				
				
				
				
				          
				}catch(Exception e){System.out.println(e);}
		return lastLogin;  
				
				
				
				
				
				
				
			}
	
	
}