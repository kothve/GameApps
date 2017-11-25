import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Calendar;

public class addTempPassword {
	
	 
	  
	
	
	public static void addPassword(String name){  
		  
		try{  
			
			String url = "jdbc:mysql://localhost/soen387";
			String username = "o_mercie";
			String password = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); 
			Calendar cal = Calendar.getInstance();  
			java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
			Calendar cal1 =  Calendar.getInstance(); 
			cal1.add(Calendar.DATE, 1);
			java.sql.Timestamp timestamp1 = new java.sql.Timestamp(cal1.getTimeInMillis());
			
			
			
			
			
			
			
		Connection con=DriverManager.getConnection(url,username,password); 
		
      
		PreparedStatement ps=con.prepareStatement("UPDATE soen387.users SET temp_password='password' WHERE username='"+name+"'");  
		  
		  
		      
		ps.executeUpdate();  
		
		
		PreparedStatement ss=con.prepareStatement("UPDATE soen387.users SET temp_time='"+timestamp+"' WHERE username='"+name+"'");  
		
		  
		 
		ss.executeUpdate();   
		
		PreparedStatement sss=con.prepareStatement("UPDATE soen387.users SET temp_expiration='"+timestamp1+"' WHERE username='"+name+"'");
		
		
		sss.executeUpdate();
		
		con.close();
		  
		          
		}catch(Exception e){System.out.println(e);}  
		
		}  


	
	
	
	
	

}
