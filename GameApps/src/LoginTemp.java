import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
  
//AUTHENTICATION


public class LoginTemp {  
	
	
	
public static boolean validate(String name,String TempPass){  
boolean status=false;  
try{  
	
	String url = "jdbc:mysql://localhost/soen387";
	String username = "o_mercie";
	String password = "odette";
	
	Class.forName("com.mysql.jdbc.Driver");
	
	
	
Connection con=DriverManager.getConnection(url,username,password); 
      
PreparedStatement ps=con.prepareStatement(  
"select * from users where username=? and temp_password=?");  
ps.setString(1,name);  
ps.setString(2,TempPass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
} 



public static boolean exist(String name){  
boolean status=false;  
try{  
	
	String url = "jdbc:mysql://localhost/soen387";
	String username = "o_mercie";
	String password = "odette";
	
	Class.forName("com.mysql.jdbc.Driver");
	
	
	
Connection con=DriverManager.getConnection(url,username,password); 
      
PreparedStatement ps=con.prepareStatement(  
"select * from users where username=? and temp_password IS NOT NULL");  
ps.setString(1,name);  
 
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
} 





}






