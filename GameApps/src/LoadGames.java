import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//show games transaction logic



public class LoadGames {
	
	
	public static ArrayList AddGames(){
		
		ArrayList gameList = new ArrayList();
		
		
try{  
    		
    		String url = "jdbc:mysql://localhost/soen387";
    		String username1 = "o_mercie";
    		String password1 = "odette";
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		
    		
    	Connection con=DriverManager.getConnection(url,username1,password1); 
    	
    	
    	String statement = "select games_id, game_name, console, price from games";
    	PreparedStatement ps=con.prepareStatement(statement);
    	
    	 ResultSet rs=ps.executeQuery();
    	 
    	 
    	 ArrayList al = null;
         
         
         
         
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
             
             
             gameList.add(al);
             
         }
		
		      
		
		
	}

catch(Exception e){System.out.println(e);}
return gameList;  
 

	
	
	

}
}