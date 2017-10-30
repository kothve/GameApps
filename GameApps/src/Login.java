import java.sql.*;  
  
//AUTHENTICATION


public class Login {  
public static boolean validate(String name,String pass){  
boolean status=false;  
try{  
	
	String url = "jdbc:mysql://localhost/soen387";
	String username = "o_mercie";
	String password = "odette";
	
	Class.forName("com.mysql.jdbc.Driver");
	
	
	
Connection con=DriverManager.getConnection(url,username,password); 
      
PreparedStatement ps=con.prepareStatement(  
"select * from users where username=? and password=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  










}  