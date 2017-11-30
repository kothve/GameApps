import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//show games transaction logic

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;



public class LoadGames extends HttpServlet {
	
	
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
	
	
	
	
public static void purchaseGame(String name, ArrayList a){
		
	
		
		
try{  
    		
    		String url = "jdbc:mysql://localhost/soen387";
    		String username1 = "o_mercie";
    		String password1 = "odette";
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		
    		
    	Connection con=DriverManager.getConnection(url,username1,password1); 
    	
    	
    	
        
        
        
        ArrayList al = a;
		java.util.Iterator itr =  al.iterator();
        while (((java.util.Iterator) itr).hasNext()) {

            
            ArrayList allShoppingCart = (ArrayList) itr.next();
            String game_name =  (String) allShoppingCart.get(0);
      
                
            		String statement = "INSERT INTO `purchase` (`username`, `game_name`) VALUES (?,?)";
        	
        	PreparedStatement ps=con.prepareStatement(statement);
        	ps.setString(1, name);
        	ps.setString(2, game_name);
        	
        	 ps.executeUpdate();        
            
            
            
 
    
 
        }
     
        
    
    	
    	
    	
    	
    	
    	
	
    	
        con.close();
		
		      
		
		
	}

catch(Exception e){System.out.println(e);}
 
 

}
	
	
public static ArrayList SpecialGames(){
	
	String url = "jdbc:mysql://localhost/soen387";
	String username = "o_mercie";
	String password = "odette";
	
	int gameInt = 1;
	
	ArrayList al = null;
    ArrayList specialList = new ArrayList();
	


    
    try {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con=DriverManager.getConnection(url,username,password); 
        //System.out.println("Connected!");
        
    	
    	
    	
    	
       

 
     
     PreparedStatement ps=con.prepareStatement("select * from games where NOT discount = '0'");
     
     
     
     
 
 ResultSet rs=ps.executeQuery();
     
     
     
     while (rs.next()) {
         al = new ArrayList<String>();

//         out.println(rs.getString(1));
//         out.println(rs.getString(2));
//         out.println(rs.getString(3));
//         out.println(rs.getString(4));
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
		
	
}catch(Exception e){System.out.println(e);}
    
    
	return specialList;
}
	




public static ArrayList ShowInventory(){
	
	ArrayList gameList = new ArrayList();
	
	
try{  
		
		String url = "jdbc:mysql://localhost/soen387";
		String username1 = "o_mercie";
		String password1 = "odette";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		
		
	Connection con=DriverManager.getConnection(url,username1,password1); 
	
	
	String statement = "select game_name from games";
	PreparedStatement ps=con.prepareStatement(statement);
	
	 ResultSet rs=ps.executeQuery();
	 
	 
	 ArrayList al = null;
     
     
     
     
     while (rs.next()) {
         al = new ArrayList<String>();
        

//         out.println(rs.getString(1));
//         out.println(rs.getString(2));
//         out.println(rs.getString(3));
//         out.println(rs.getString(4));
         al.add(rs.getString(1));
         
         
         
         
         gameList.add(al);
         
     }
	
	      
	
	
}

catch(Exception e){System.out.println(e);}
return gameList;  






}







public static ArrayList Quantity(){
	
	ArrayList gameList = new ArrayList();
	
	
try{  
		
		String url = "jdbc:mysql://localhost/soen387";
		String username1 = "o_mercie";
		String password1 = "odette";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		
		
	Connection con=DriverManager.getConnection(url,username1,password1); 
	
	
	String statement = "select quantity from games";
	PreparedStatement ps=con.prepareStatement(statement);
	
	 ResultSet rs=ps.executeQuery();
	 
	 
	 ArrayList al = null;
     
     
     
     
     while (rs.next()) {
         al = new ArrayList();
        

//         out.println(rs.getString(1));
//         out.println(rs.getString(2));
//         out.println(rs.getString(3));
//         out.println(rs.getString(4));
         al.add(rs.getInt(1));
         
         
         
         
         gameList.add(al);
         
     }
	
	      
	
	
}

catch(Exception e){System.out.println(e);}
return gameList;  






}
























   
    
}